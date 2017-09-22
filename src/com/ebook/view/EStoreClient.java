package com.ebook.view;

import com.ebook.dal.CustomerDAO;
import com.ebook.model.customer.Customer;

public class EStoreClient {

	public static void main(String[] args) {
		// Testing Customer Module
		// Testing getCustomerById
		CustomerDAO customerDAO = new CustomerDAO();
		Customer hanSolo = customerDAO.getCustomer("A002");
		System.out.println(hanSolo.getBillingAddress().getCity());
	}

}
