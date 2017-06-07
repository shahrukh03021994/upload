package com.niit.GroceryBackendApp.config;


import java.util.Properties;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.GroceryBackendApp.dao.CartDao;
import com.niit.GroceryBackendApp.dao.CategoryDao;
import com.niit.GroceryBackendApp.dao.OrdersDao;
import com.niit.GroceryBackendApp.dao.SupplierDao;
import com.niit.GroceryBackendApp.dao.UserDao;
import com.niit.GroceryBackendApp.daoimpl.CartDaoImpl;
import com.niit.GroceryBackendApp.daoimpl.OrderDaoImpl;
import com.niit.GroceryBackendApp.model.CartModel;
import com.niit.GroceryBackendApp.model.Category;
import com.niit.GroceryBackendApp.model.Orders;
import com.niit.GroceryBackendApp.model.Product;
import com.niit.GroceryBackendApp.model.Supplier;
import com.niit.GroceryBackendApp.model.User;






@Configuration
@ComponentScan("com.niit.GroceryBackendAppp")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Autowired
	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		System.out.println("Data Source Method");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/sss");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
	
		System.out.println("Data Source Created");
		return dataSource;
	}
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");

		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		
		sessionBuilder.addAnnotatedClass(Orders.class);
		sessionBuilder.addAnnotatedClass(CartModel.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		
		
		//sessionBuilder.scanPackages("com.niit.GroceryBackendApp");
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name="categoryDAO")
	public CategoryDao getCategoryDAO(SessionFactory sessionFactory)
	{
		return new CategoryDao(sessionFactory);
	}
	
	@Autowired
	@Bean(name="supplierDAO")
	public SupplierDao getSupplierDAO(SessionFactory sessionFactory)
	{
		return new SupplierDao(sessionFactory);
	}
	
	
	@Autowired
	@Bean(name="userDAO")
	public UserDao getUserDAO(SessionFactory sessionFactory)
	{
		return new UserDao(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "cartDAO")
	public CartDao getCartDAO(SessionFactory sessionFactory) {
		return new CartDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "ordersDAO")
	public OrdersDao getOrdersDAO(SessionFactory sessionFactory) {
		return new OrderDaoImpl(sessionFactory);
	}

	
	
    @Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

}
