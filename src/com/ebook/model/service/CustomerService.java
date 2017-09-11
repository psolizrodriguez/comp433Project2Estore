package com.ebook.model.service;

import com.ebook.dal.CustomerDAO;
import com.ebook.model.customer.Customer;

public class CustomerService {
	private CustomerDAO custDAO = new CustomerDAO();
	
	//search customer by ID from the DB
	public Customer findCustomerById(String customerId) {
			
		try {
			Customer customer = custDAO.getCustomer(customerId);
	    	return customer;
	    } catch (Exception se) {
	      System.err.println("CustomerService: Threw a Exception retrieving customer.");
	      System.err.println(se.getMessage());
	    }
		return null;
	}
	
	//Insert a new customer in the DB
	public void addCustomer(Customer customer) {
		
		try {
			custDAO.addCustomer(customer);
	    } catch (Exception se) {
	      System.err.println("CustomerService: Threw a Exception retrieving customer.");
	      System.err.println(se.getMessage());
	    }
	}
	
}
