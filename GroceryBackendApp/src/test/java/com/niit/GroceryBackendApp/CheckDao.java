package com.niit.GroceryBackendApp;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.GroceryBackendApp.dao.CategoryDao;
import com.niit.GroceryBackendApp.dao.SupplierDao;
import com.niit.GroceryBackendApp.model.Category;
import com.niit.GroceryBackendApp.model.Supplier;

public class CheckDao 
{

	@Autowired static AnnotationConfigApplicationContext context;
	
	 static CategoryDao  categoryDAO;
	static SupplierDao supplierDAO;

	
	//The above objects need to initialize
	/**
	 * This method is going execute before calling any one of test case
	 * and will execute only once
	 */
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.GroceryBackendApp");
		context.refresh();
		
		//get the userDAO from context
		categoryDAO =  (CategoryDao) context.getBean("categoryDAO");
		supplierDAO=(SupplierDao)context.getBean("supplierDAO");
		//get the user from context
		
		
	}

	
	
	 
	@Test
	public void updateUserTestCase()
	{
		/*Category c1=new Category();
		c1.setCid(44);
		c1.setName("milk4");
		categoryDAO.insertCategory(c1);
	

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals(c1.getCid(),c1.getCid());
		*/
		
		Supplier s=new Supplier();
		s.setSid(11);
		s.setSupplierName("s1");
		supplierDAO.insertSupplier(s);
		assertEquals(s.getSid(), s.getSid());
		
	}
}
