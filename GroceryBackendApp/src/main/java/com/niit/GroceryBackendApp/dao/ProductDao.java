package com.niit.GroceryBackendApp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.GroceryBackendApp.model.Category;
import com.niit.GroceryBackendApp.model.Product;
@SuppressWarnings("deprecation")
@Repository("productDAO")
public class ProductDao {

	
	
	@Autowired
	SessionFactory sessionFactory;

	public ProductDao(SessionFactory sessionFactory) {
		//super();
		this.sessionFactory = sessionFactory;
	}
	
	
	
	public void insertProduct(Product product)
	{
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
        // product.setImgcount(imgcount);
		session.persist(product);
		
		session.getTransaction().commit();
		//session.getTransaction().commit();
		//session.close();
		
	}
	
	
	public List<Product> retrieve()
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//session.find();
		
		@SuppressWarnings("unchecked")
		List<Product> list=session.createQuery("from Product").list();
		//session.close();
		session.getTransaction().commit();
		//session.flush();

		return list;
	}
	
	
	public void deleteProduct(int pid)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();

		Product product=(Product)session.get(Product.class,pid);
		session.delete(product);
		session.getTransaction().commit();

	}
	
	
	public Product findbyId(int id) {

		Session session=sessionFactory.openSession();
		Product p=null;
		try{
			session.beginTransaction();
		 p=	session.get(Product.class, id);
		session.getTransaction().commit();
			
			
		}catch(HibernateException ex){
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		return p;
	
	}
	
public void update(Product p) {
		
		Session session=sessionFactory.openSession();
		
	
			session.beginTransaction();


			session.update(p);
			session.getTransaction().commit();
		
		
		
	}

public List<Product> getProductsByCategory(int cid) {
Session session=sessionFactory.openSession();
List<Product> products =null;
session.beginTransaction();
products= session.createQuery("from Product where cid="+cid).list();   
session.getTransaction().commit();
 return products;
}
	
}
