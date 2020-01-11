package com.capgemini.springproject.service;

import java.util.List;

import com.capgemini.springproject.dto.Authentication;
import com.capgemini.springproject.dto.OrderInfo;

public interface OrderService {
public boolean addProduct(OrderInfo order);
	
	public OrderInfo getProduct(int id);
	
	public List<OrderInfo> getAllProducts();
	
	public boolean deleteOrder(int id);
	
	public boolean modifyOrder(int id);
	
	public boolean register(Authentication account);
	
	public Authentication login(Authentication credentials);
}
