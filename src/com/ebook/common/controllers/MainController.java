package com.ebook.common.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ebook.common.utility.ConfigManager;
import com.ebook.model.customer.Address;
import com.ebook.model.customer.Customer;
import com.ebook.model.item.Book;
import com.ebook.model.item.Product;
import com.ebook.service.customer.CustomerService;
import com.ebook.service.item.ProductService;

@Controller
public class MainController {
	private static final Logger LOGGER = ConfigManager.getLogger(MainController.class);
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ProductService productService;

	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		// Testing addCustomer
		LOGGER.info("Adding Customer julia.cicale");
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
		// Adding products
		LOGGER.info("Adding Product FitBit Alta");
		Product fitbitAlta = new Product();
		fitbitAlta.setProductId("001");
		fitbitAlta.setTitle("FitBit Alta");
		fitbitAlta.setDescription("Activity Tracker");
		productService.add(fitbitAlta);
		LOGGER.info("Adding Product Bluetooth Headphones");
		Product headphones = new Product();
		headphones.setProductId("002");
		headphones.setTitle("Bluetooth Headphones");
		headphones.setDescription("Wireless and comfortable headphones for running");
		productService.add(headphones);
		LOGGER.info("Adding Product Laptop Bag");
		Product laptopBag = new Product();
		laptopBag.setProductId("003");
		laptopBag.setTitle("Laptop Bag");
		laptopBag.setDescription("Fits laptops of up to 15 inches");
		productService.add(laptopBag);
		Book odyssey = new Book();
		odyssey.setProductId("004");
		odyssey.setTitle("The Odyssey");
		odyssey.setDescription(
				"Sing to me of the man, Muse, the man of twists and turns driven time and again off course, once he had plundered the hallowed heights of Troy");
		odyssey.setISBN("9785040381791");
		odyssey.setAuthor("Homer");
		productService.add(odyssey);
		return "index";
	}

}