package com.niit.GroceryBackendApp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "User") 
public class User implements Serializable{

	@Id
	@NotEmpty(message="Enter The Email")
	@Email(message="Enter valid email")
	private String id;
	
	

	@NotEmpty(message="Name is Empty")
	@NotNull(message="Name is null")
	@Column(name = "name")
	private String name;

	
	@NotEmpty(message="Passowrd is Empty")
	@NotNull(message="Password is Null")
	private String password;
	

	
	private String role;
	
	@NotEmpty(message="Address is empty")
	@NotNull
	private String address;
	
	@Pattern(regexp="[\\d]{10}",message="Please enter the digits")
	@NotEmpty(message="phone is empty")
	@Size(min=0,max=14,message="Enter correct phone")
	private String phone;
	
	/*@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
	private Set<Cart> cart = new HashSet<Cart>(0);
*/
	private boolean enabled;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
	private Set<Orders> orders= new HashSet<Orders>(0);

	// getters + setters
	
	
	public String getAddress() {
		return address;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public String getName() {
	
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}



}
