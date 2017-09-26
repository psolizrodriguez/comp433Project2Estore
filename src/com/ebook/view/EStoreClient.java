package com.ebook.view;

import com.ebook.dal.CustomerDAO;
import com.ebook.dal.OrderDAO;
import com.ebook.model.customer.Customer;
import com.ebook.model.order.Order;

public class EStoreClient {

	public static void main(String[] args) {
		// Testing Customer Module
		// Testing getCustomerById
		CustomerDAO customerDAO = new CustomerDAO();
		Customer hanSolo = customerDAO.getCustomer("A002");
		System.out.println(hanSolo.getBillingAddress().getCity());
		System.out.println(hanSolo.getShippingAddress().getCity());
		
		//Testing Order Module
		//Testing getOrderById
		OrderDAO orderDAO = new OrderDAO();
		Order order1 = orderDAO.getOrder(1);
		System.out.println(order1.getOrderState());
		
	}

}
