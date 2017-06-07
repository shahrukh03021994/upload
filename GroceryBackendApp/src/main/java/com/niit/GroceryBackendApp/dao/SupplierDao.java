package com.niit.GroceryBackendApp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.GroceryBackendApp.model.Category;
import com.niit.GroceryBackendApp.model.Orders;
import com.niit.GroceryBackendApp.model.Product;
import com.niit.GroceryBackendApp.model.Supplier;

@SuppressWarnings("deprecation")
@Repository("supplierDAO")
public class SupplierDao {
	
	@Autowired
	SessionFactory sessionFactory;

	

	public SupplierDao(SessionFactory sessionFactory) {
		//super();
		this.sessionFactory = sessionFactory;
	}

	

	public void insertSupplier(Supplier supplier)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
         
		session.saveOrUpdate(supplier);
		session.getTransaction().commit();
		//session.getTransaction().commit();
		//session.close();
		
	}
	
	public List<Supplier> retrieve()
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//session.find();
		
		@SuppressWarnings("unchecked")
		List<Supplier> list=session.createQuery("from Supplier").list();
		//session.close();
		session.getTransaction().commit();
		//session.flush();
		return list;
	}
	public Supplier findbyId(int id) {

		Session session=sessionFactory.openSession();
		Supplier p=null;
		try{
			session.beginTransaction();
		 p=	session.get(Supplier.class, id);
		session.getTransaction().commit();
			
			
		}catch(HibernateException ex){
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		return p;
	
	}
}
