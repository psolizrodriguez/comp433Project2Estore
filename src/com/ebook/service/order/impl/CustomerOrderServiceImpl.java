package com.ebook.service.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.dao.order.CustomerOrderDao;
import com.ebook.model.order.CustomerOrder;
import com.ebook.service.order.CustomerOrderService;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {
	@Autowired
	CustomerOrderDao dao;

	@Override
	public CustomerOrder save(CustomerOrder customerOrder) {
		return dao.save(customerOrder);
	}

	@Override
	public List<CustomerOrder> listAll() {
		return dao.listAll();
	}

	@Override
	public CustomerOrder getById(String customerOrderId) {
		return dao.getById(customerOrderId);
	}

	@Override
	public boolean remove(CustomerOrder customerOrder) {
		return dao.remove(customerOrder);
	}

}
