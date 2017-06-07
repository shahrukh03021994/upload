package com.niit.GroceryBackendApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.niit.GroceryBackendApp.model.User;

@Component
public class ListCheck 
{

	public List<User> listOUser(){
		User u1=new User();
		u1.setId("1");
		u1.setName("shahrukh");
		u1.setPassword("niit");
		u1.setRole("admin");
			
		User u2=new User();
		u2.setId("2");
		u2.setName("shahrukh2");
		u2.setPassword("niit2");
		u2.setRole("admin2");
		
		List<User> list=new ArrayList<User>();
		list.add(u1);
		list.add(u2);
		return list;
		
		
	}
}
