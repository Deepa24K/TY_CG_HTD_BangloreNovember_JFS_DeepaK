package com.capgemini.springproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springproject.dao.ProductDao;
import com.capgemini.springproject.dto.Authentication;
import com.capgemini.springproject.dto.ProductInfo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao dao;

	@Override
	public boolean addProduct(ProductInfo product) {
		return dao.addProduct(product);
	}

	@Override
	public ProductInfo getProduct(int id) {
		return dao.getProduct(id);
	}

	@Override
	public List<ProductInfo> getAllProducts() {
		return dao.getAllProducts();
	}

	@Override
	public boolean deleteProduct(int id) {
		return dao.deleteProduct(id);
	}

	@Override
	public boolean modifyProduct(int id) {
		return dao.modifyProduct(id);
	}

	@Override
	public boolean register(Authentication account) {
		return dao.register(account);
	}

	@Override
	public Authentication login(Authentication credentials) {
		return dao.login(credentials);
	}

	

}
