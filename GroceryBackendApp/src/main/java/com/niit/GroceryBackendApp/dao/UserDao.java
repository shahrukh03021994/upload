package com.niit.GroceryBackendApp.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.GroceryBackendApp.model.Category;
import com.niit.GroceryBackendApp.model.User;
@SuppressWarnings("deprecation")
@Repository("userDAO")
public class UserDao {
	
	@Autowired
	SessionFactory sessionFactory;

	
	
	public UserDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	
	public void insertUser(User user)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
         
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		//session.getTransaction().commit();
		//session.close();
		
	}
	
	
	

	public User findbyUserId(String id) {

		Session session=sessionFactory.openSession();
		User p=null;
		try{
			session.beginTransaction();
		 p=	session.get(User.class, id);
		session.getTransaction().commit();
			
			
		}catch(HibernateException ex){
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		return p;
	
	}
}

