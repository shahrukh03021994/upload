package com.niit.GroceryBackendApp;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.niit.GroceryBackendApp.model.User;

public class UserCommandValidator implements Validator{

	public boolean supports(Class<?> type) {
		// TODO Auto-generated method stub
	Boolean status=	type.isAssignableFrom(User.class);
	return status;
		}

	public void validate(Object cmd, Errors error) {
		// TODO Auto-generated method stub
		User uc=new User();
		if(uc.getId()==null || uc.getId().trim().equals("")){
			
			
			
			error.rejectValue("id", null,"Email is Mandatory");
		}
		if(uc.getPassword()==null||uc.getPassword().trim().equals("")){
			
			error.rejectValue("password", null,"Password id mandatory");
			
			
		}
	}

	
	
}
