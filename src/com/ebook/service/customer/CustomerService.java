package com.ebook.service.customer;

import java.util.List;

import com.ebook.model.customer.Customer;

public interface CustomerService {
	public Customer save(Customer customer);

	public List<Customer> listAll();

	public Customer getById(Long customerId);

	public boolean remove(Customer menu);
}
