package com.niit;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.GroceryBackendApp.dao.CategoryDao;
import com.niit.GroceryBackendApp.dao.ProductDao;
import com.niit.GroceryBackendApp.dao.SupplierDao;
import com.niit.GroceryBackendApp.model.Category;
import com.niit.GroceryBackendApp.model.Product;
import com.niit.GroceryBackendApp.model.Supplier;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	ProductDao productDao;

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	SupplierDao supplierDao;
/*
	@RequestMapping("/create")
	public ModelAndView createForm() {
		ModelAndView mav = new ModelAndView();
		// mav.addObject("product", new Product());
		mav.addObject("category", new Category());
		// mav.addObject("supplier", new Supplier());
		// mav.addObject("categories", cService.getAllCategory());
		
  
		mav.addObject("cat", categoryDao.retrieve());
	 
 		mav.setViewName("cat2");
		return mav;
	}*/

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveCategory(@RequestParam("cid") int cid, @RequestParam("name") String name) {
		ModelAndView mav = new ModelAndView();

		Category c = new Category();
		c.setCid(cid);
		c.setName(name);
		categoryDao.insertCategory(c);
		// mav.setViewName("redirect:/categorylist?save");
		mav.setViewName("model");
		return mav;
	}

	@RequestMapping("/categorylist")
	public ModelAndView contactList() {
		ModelAndView mav = new ModelAndView("categoryList");
		// User user = (User) session.getAttribute("user");
		mav.addObject("contactList", categoryDao.retrieve());
		return mav;
	}

	@RequestMapping(value = "/Product")
	public String showProduct(Model m)

	{

		m.addAttribute("product", new Product());

		m.addAttribute("cat", categoryDao.retrieve());
		m.addAttribute("sat", supplierDao.retrieve());
		return "cat2";

	}
	
	
	
	

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public String saveProduct(HttpServletRequest request, @RequestParam("file") MultipartFile file) {

		ModelAndView mav = new ModelAndView();
		Product product = new Product();

		// System.out.println(request.getParameter("pname"));
		product.setName(request.getParameter("pName"));
		product.setCategory(categoryDao.findbyId(Integer.parseInt(request.getParameter("pCategory"))));
		product.setSupplier(supplierDao.findbyId(Integer.parseInt(request.getParameter("pSupplier"))));
		product.setDescription(request.getParameter("pDescription"));
		product.setPrice(Float.parseFloat(request.getParameter("pPrice")));
		product.setStock(Integer.parseInt(request.getParameter("pQuantity")));

		String filepath = request.getSession().getServletContext().getRealPath("/");
		

		String filname = file.getOriginalFilename();
		product.setImgName(filname);
		productDao.insertProduct(product);
		System.out.println("File path File" + filepath + " " + filname);

		try {
			// byte imagebyte[] = product.getPimage().getBytes();
			byte imagebyte[] = file.getBytes();
			BufferedOutputStream fos = new BufferedOutputStream(
					new FileOutputStream(filepath + "/resources/image/" + filname));
			fos.write(imagebyte);
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return "redirect:/productList";
		return "model2";

	}

	@RequestMapping("/productList")
	public ModelAndView productList() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("productList", productDao.retrieve());
		mav.setViewName("productList");
		return mav;
	}

	@RequestMapping("/deleteProduct/{pid}")
	public String delete(@PathVariable("pid") int pid) {
		// contactDAO.delete(contactId);
		productDao.deleteProduct(pid);
		return "redirect:/admin/productList?del";
	}

	@RequestMapping("/updateProduct")
	public ModelAndView editView(@RequestParam("id") int pid) {
		ModelAndView mav = new ModelAndView();

		Product p = productDao.findbyId(pid);
		// ModelAndView mav = new ModelAndView("category");
		// mav.addObject("supplier", new Supplier());
		mav.addObject("pro", p);// Domain as Command
		mav.addObject("clist", categoryDao.retrieve());
		mav.addObject("slist", supplierDao.retrieve());
		mav.setViewName("updateProduct");
		return mav;
	}

	@RequestMapping(value = "/productUpdate", method = RequestMethod.POST)
	public ModelAndView updateProduct(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
		System.out.println("called");
		ModelAndView mav = new ModelAndView();

		String pid = request.getParameter("pid");
		String pname = request.getParameter("pName");
		// System.out.println(n);
		String ct = request.getParameter("pCategory");
		String sp = request.getParameter("pSupplier");

		String p = request.getParameter("pPrice");
		String d = request.getParameter("pDescription");

		String q = request.getParameter("pQuantity");

		Product pp = new Product();
		pp.setId(Integer.parseInt(pid));
		pp.setName(pname);
		pp.setCategory(categoryDao.findbyId(Integer.parseInt(ct)));
		pp.setSupplier(supplierDao.findbyId(Integer.parseInt(sp)));
		pp.setPrice(Float.parseFloat(p));

		pp.setDescription(d);
		pp.setStock(Integer.parseInt(q));

		String filepath = request.getSession().getServletContext().getRealPath("/");
	
		String filname = file.getOriginalFilename();
		pp.setImgName(filname);
		productDao.update(pp);
		System.out.println("File path File" + filepath + " " + filname);

		try {
			// byte imagebyte[] = product.getPimage().getBytes();
			byte imagebyte[] = file.getBytes();
			BufferedOutputStream fos = new BufferedOutputStream(
					new FileOutputStream(filepath + "/resources/image/" + filname));
			fos.write(imagebyte);
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.setViewName("redirect:/admin/productList?update");
		return mav;

	}
	@ModelAttribute
	public void addAttributes(Model model) {
	   model.addAttribute("catList", categoryDao.retrieve());
	} 

	@RequestMapping("/addSupplier")
	public ModelAndView addSupplier() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("supplier", new Supplier());
		// mav.addObject("category", new Category());
		mav.setViewName("cat2");

		return mav;

	}

	@RequestMapping(value = "/saveSupplier", method = RequestMethod.POST)
	public ModelAndView saveSupplier(@RequestParam("sid") int sid, @RequestParam("supplierName") String supplierName) {
		ModelAndView mav = new ModelAndView();
		Supplier ss = new Supplier();
		ss.setSid(sid);
		ss.setSupplierName(supplierName);
		supplierDao.insertSupplier(ss);

		mav.setViewName("redirect:/admin/supplierlist");
		return mav;

	}
	
	@RequestMapping("/supplierlist")
	public ModelAndView supplieList() {
		ModelAndView mav = new ModelAndView("supplierList");
		// User user = (User) session.getAttribute("user");
		mav.addObject("supplierList", supplierDao.retrieve());
		return mav;
	}
}
