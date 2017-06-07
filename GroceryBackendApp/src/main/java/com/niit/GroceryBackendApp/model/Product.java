package com.niit.GroceryBackendApp.model;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;
@Entity
@Table(name="Product")
public class Product implements Serializable 


{
	
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	private  Float price;
	private int stock;
/*
	@Transient
	List<MultipartFile> detailimage;*/ 
	//private String cid;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cid")
    private Category category;
	
	/*
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
    private Cart cart;*/
	
	//private String sid;
	
	@ManyToOne
	@JoinColumn(name="sid")
	private Supplier supplier;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Transient
	MultipartFile pimage;

	
	private String imgName;	

	


	

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public MultipartFile getPimage() {
		return pimage;
	}

	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	
}
