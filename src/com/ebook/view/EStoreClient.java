package com.ebook.view;

import com.ebook.dal.CustomerDAO;
import com.ebook.dal.OrderDAO;
import com.ebook.model.customer.Address;
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
		
		//Testing addCustomer
		Customer juliaCicale = new Customer();
		juliaCicale.setCustomerId("A006");
		juliaCicale.setFirstName("Julia");
		juliaCicale.setLastName("Cicale");
		juliaCicale.setUserName("julia.cicale");
		juliaCicale.setPassword("julia.cicale");
		Address juliaShip = new Address();
		juliaShip.setAddressId(00006);
		juliaShip.setStreet("123 Home St.");
		juliaShip.setUnit("Unit 2");
		juliaShip.setCity("Chicago");
		juliaShip.setState("IL");
		juliaShip.setZip("60657");
		Address juliaBill = new Address();
		juliaBill.setAddressId(00007);
		juliaBill.setStreet("123 Business Rd.");
		juliaBill.setUnit("Ste 500");
		juliaBill.setCity("Chicago");
		juliaBill.setState("IL");
		juliaBill.setZip("60601");
		juliaCicale.setShippingAddress(juliaShip);
		juliaCicale.setBillingAddress(juliaBill);
		customerDAO.addCustomer(juliaCicale);
		
		//Testing Order Module
		//Testing getOrderById
		OrderDAO orderDAO = new OrderDAO();
		Order order1 = orderDAO.getOrder(1);
		System.out.println(order1.getOrderState());
		
	}

}
