package com.ebook.service.customer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.dao.customer.CustomerDao;
import com.ebook.model.customer.Customer;
import com.ebook.service.customer.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerDao dao;

	@Override
	public Customer save(Customer customer) {
		return dao.save(customer);
	}

	@Override
	public List<Customer> listAll() {
		return dao.listAll();
	}

	@Override
	public Customer getById(String customerId) {
		return dao.getById(customerId);
	}

	@Override
	public boolean remove(Customer customer) {
		return dao.remove(customer);
	}

}
