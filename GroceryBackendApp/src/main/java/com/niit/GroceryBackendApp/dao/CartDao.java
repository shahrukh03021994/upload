package com.niit.GroceryBackendApp.dao;


import java.io.IOException;
import java.util.List;

import com.niit.GroceryBackendApp.model.CartModel;
import com.niit.GroceryBackendApp.model.Product;



public interface CartDao
{

	
	void insert(CartModel cart);
	public List<CartModel> findCartById(String userId);
	public void delete(int cart);
	public void update(CartModel cart);
	public CartModel getCartById(int pid,String userEmail);
}