package com.capgemini.springproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.springproject.dto.Authentication;
import com.capgemini.springproject.dto.OrderInfo;
import com.capgemini.springproject.exception.ProductException;

@Repository
public class OrderDaoImpl implements OrderDao{
	
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public boolean addProduct(OrderInfo order) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(order);
			transaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public OrderInfo getProduct(int id) {
		EntityManager manager = factory.createEntityManager();
		OrderInfo order = manager.find(OrderInfo.class, id);
		return order;
	}

	@Override
	public List<OrderInfo> getAllProducts() {
		EntityManager manager = factory.createEntityManager();
		String getall = "from ProductInfo";
		TypedQuery<OrderInfo> query = manager.createQuery(getall, OrderInfo.class);
		return query.getResultList();
	}

	@Override
	public boolean deleteOrder(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		OrderInfo order = manager.find(OrderInfo.class, id);
		if (order != null) {
			transaction.begin();
			manager.remove(order);
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean modifyOrder(int id) {
		EntityManager manager = factory.createEntityManager();
		OrderInfo order = manager.find(OrderInfo.class, id);
		EntityTransaction transaction = manager.getTransaction();
		if (order != null) {
			transaction.begin();
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean register(Authentication account) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(account);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new ProductException("Account with same email already exists");
		}
	}

	@Override
	public Authentication login(Authentication credentials) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from Authentication where email=:email";
		TypedQuery<Authentication> query = manager.createQuery(jpql, Authentication.class);
		query.setParameter("email", credentials.getEmail());
		try {
			Authentication account = query.getSingleResult();
			if (account.getPassword().equals(credentials.getPassword())) {
				return account;
			} else {
				System.out.println("here above valid");
				return null;
			}
		} catch (Exception e) {
			throw new ProductException("Account does not exist");
		}
	}

}
