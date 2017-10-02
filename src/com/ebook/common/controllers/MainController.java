package com.ebook.common.controllers;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ebook.common.utility.ConfigManager;
import com.ebook.model.customer.Address;
import com.ebook.model.customer.Customer;
import com.ebook.model.item.Book;
import com.ebook.model.item.Inventory;
import com.ebook.model.item.Partner;
import com.ebook.model.item.Product;
import com.ebook.service.customer.CustomerService;
import com.ebook.service.item.PartnerService;
import com.ebook.service.item.ProductService;

@Controller
public class MainController {
	private static final Logger LOGGER = ConfigManager.getLogger(MainController.class);
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ProductService productService;
	@Autowired
	private PartnerService partnerService;

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
		// Adding Partners
		LOGGER.info("Adding Partner Amazon");
		Partner amazon = new Partner();
		amazon.setPartnerId("001");
		amazon.setName("Amazon");
		amazon.setUserName("amazon");
		amazon.setPassword("amazon12345");
		List<Inventory> amazonInventory = new LinkedList<>();
		amazonInventory.add(new Inventory("001-001", fitbitAlta, 150.0, 10));
		amazonInventory.add(new Inventory("001-002", headphones, 80.0, 10));
		amazonInventory.add(new Inventory("001-003", laptopBag, 15.0, 10));
		amazon.setInventory(amazonInventory);
		partnerService.add(amazon);
		LOGGER.info("Adding Partner Ebay");
		Partner ebay = new Partner();
		ebay.setPartnerId("002");
		ebay.setName("Ebay");
		ebay.setUserName("ebay");
		ebay.setPassword("ebay12345");
		List<Inventory> ebayInventory = new LinkedList<>();
		ebayInventory.add(new Inventory("002-001", fitbitAlta, 160.0, 15));
		ebayInventory.add(new Inventory("002-002", headphones, 70.0, 15));
		ebayInventory.add(new Inventory("002-003", laptopBag, 20.0, 15));
		ebay.setInventory(ebayInventory);
		partnerService.add(ebay);
		return "index";
	}

}