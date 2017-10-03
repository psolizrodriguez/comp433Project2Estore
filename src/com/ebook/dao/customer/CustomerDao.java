package com.ebook.dao.customer;

import java.util.List;

import com.ebook.common.dao.Dao;
import com.ebook.model.customer.Customer;

public interface CustomerDao extends Dao {
	public Customer save(Customer customer);

	public List<Customer> listAll();

	public Customer getById(String customerId);

	public boolean remove(Customer customer);
}
