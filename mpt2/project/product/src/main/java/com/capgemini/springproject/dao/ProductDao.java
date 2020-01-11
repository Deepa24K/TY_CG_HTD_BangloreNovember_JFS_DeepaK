package com.capgemini.springproject.dao;

import java.util.List;

import com.capgemini.springproject.dto.Authentication;
import com.capgemini.springproject.dto.ProductInfo;

public interface ProductDao {

	public boolean addProduct(ProductInfo product);
	
	public ProductInfo getProduct(int id);
	
	public List<ProductInfo> getAllProducts();
	
	public boolean deleteProduct(int id);
	
	public boolean modifyProduct(int id);
	
	public boolean register(Authentication account);
	
	public Authentication login(Authentication credentials);
}
