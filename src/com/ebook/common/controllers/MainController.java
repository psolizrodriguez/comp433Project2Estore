package com.ebook.common.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ebook.common.utility.ConfigManager;
import com.ebook.model.customer.Address;
import com.ebook.model.customer.Customer;
import com.ebook.service.customer.CustomerService;

@Controller
public class MainController {
	private static final Logger LOGGER = ConfigManager.getLogger(MainController.class);
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		// Testing addCustomer
		Customer juliaCicale = new Customer();
		juliaCicale.setCustomerId("A006");
		juliaCicale.setFirstName("Julia");
		juliaCicale.setLastName("Cicale");
		juliaCicale.setUserName("julia.cicale");
		juliaCicale.setPassword("julia.cicale");
		Address juliaShip = new Address();
		juliaShip.setAddressId("00006");
		juliaShip.setStreet("123 Home St.");
		juliaShip.setUnit("Unit 2");
		juliaShip.setCity("Chicago");
		juliaShip.setState("IL");
		juliaShip.setZip("60657");
		Address juliaBill = new Address();
		juliaBill.setAddressId("00007");
		juliaBill.setStreet("123 Business Rd.");
		juliaBill.setUnit("Ste 500");
		juliaBill.setCity("Chicago");
		juliaBill.setState("IL");
		juliaBill.setZip("60601");
		juliaCicale.setShippingAddress(juliaShip);
		juliaCicale.setBillingAddress(juliaBill);
		customerService.add(juliaCicale);
		return "index";
	}
}