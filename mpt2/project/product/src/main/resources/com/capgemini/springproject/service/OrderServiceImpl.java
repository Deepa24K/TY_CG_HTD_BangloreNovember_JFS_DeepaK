package com.capgemini.springproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springproject.dao.OrderDao;
import com.capgemini.springproject.dto.Authentication;
import com.capgemini.springproject.dto.OrderInfo;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao dao;

	@Override
	public boolean addProduct(OrderInfo order) {
		return dao.addProduct(order);
	}

	@Override
	public OrderInfo getProduct(int id) {
		return dao.getProduct(id);
	}

	@Override
	public List<OrderInfo> getAllProducts() {
		return dao.getAllProducts();
	}

	@Override
	public boolean deleteOrder(int id) {
		return dao.deleteOrder(id);
	}

	@Override
	public boolean modifyOrder(int id) {
		return dao.modifyOrder(id);
	}

	@Override
	public boolean register(Authentication account) {
		return false;
	}

	@Override
	public Authentication login(Authentication credentials) {
		return null;
	}

}
