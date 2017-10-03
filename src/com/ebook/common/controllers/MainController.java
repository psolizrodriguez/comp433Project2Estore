package com.ebook.common.controllers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ebook.common.constants.AppBaseConstantsWeb;
import com.ebook.model.customer.Address;
import com.ebook.model.customer.Customer;
import com.ebook.model.item.Book;
import com.ebook.model.item.Inventory;
import com.ebook.model.item.Partner;
import com.ebook.model.item.Product;
import com.ebook.model.item.Review;
import com.ebook.model.order.CreditCardPayment;
import com.ebook.model.order.CustomerOrder;
import com.ebook.model.order.OrderDetail;
import com.ebook.model.order.PayPalPayment;
import com.ebook.model.order.PaymentMethod;
import com.ebook.model.order.PickUpOrder;
import com.ebook.model.order.ShippingOrder;
import com.ebook.service.customer.CustomerService;
import com.ebook.service.item.InventoryService;
import com.ebook.service.item.PartnerService;
import com.ebook.service.item.ProductService;
import com.ebook.service.order.CustomerOrderService;
import com.ebook.service.order.OrderDetailService;

@Controller
public class MainController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ProductService productService;
	@Autowired
	private PartnerService partnerService;
	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private CustomerOrderService customerOrderService;
	@Autowired
	private OrderDetailService orderDetailService;

	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		// Testing addCustomer
		System.out.println("Adding Customer julia.cicale");
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
		customerService.save(juliaCicale);
		// Adding products
		System.out.println("Adding Product FitBit Alta");
		Product fitbitAlta = new Product();
		fitbitAlta.setProductId("001");
		fitbitAlta.setTitle("FitBit Alta");
		fitbitAlta.setDescription("Activity Tracker");
		productService.save(fitbitAlta);
		System.out.println("Adding Product Bluetooth Headphones");
		Product headphones = new Product();
		headphones.setProductId("002");
		headphones.setTitle("Bluetooth Headphones");
		headphones.setDescription("Wireless and comfortable headphones for running");
		productService.save(headphones);
		System.out.println("Adding Product Laptop Bag");
		Product laptopBag = new Product();
		laptopBag.setProductId("003");
		laptopBag.setTitle("Laptop Bag");
		laptopBag.setDescription("Fits laptops of up to 15 inches");
		productService.save(laptopBag);
		Book odyssey = new Book();
		odyssey.setProductId("004");
		odyssey.setTitle("The Odyssey");
		odyssey.setDescription(
				"Sing to me of the man, Muse, the man of twists and turns driven time and again off course, once he had plundered the hallowed heights of Troy");
		odyssey.setISBN("9785040381791");
		odyssey.setAuthor("Homer");
		productService.save(odyssey);
		// Adding Partners
		System.out.println("Adding Partner Amazon");
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
		partnerService.save(amazon);
		System.out.println("Adding Partner Ebay");
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
		partnerService.save(ebay);
		// Searching for Inventory
		System.out.println("Searching for Inventory");
		List<Inventory> searchFitbit = inventoryService.listAllInventoryByKeywords("FitBit");
		if (searchFitbit.size() > 0) {
			for (Inventory inventory : searchFitbit) {
				System.out.println(inventory.getProduct().getTitle() + "(" + inventory.getProduct().getProductId()
						+ "), " + inventory.getQuantity() + " available @ " + inventory.getPrice());
			}
		} else {
			System.out.println("No records Found");
		}
		System.out.println("Searching for Inventory");
		List<Inventory> searchHeadphones = inventoryService.listAllInventoryByKeywords("Headphones");
		if (searchHeadphones.size() > 0) {
			for (Inventory inventory : searchHeadphones) {
				System.out.println(inventory.getProduct().getTitle() + "(" + inventory.getProduct().getProductId()
						+ "), " + inventory.getQuantity() + " available @ " + inventory.getPrice());
			}
		} else {
			System.out.println("No records Found");
		}
		// Placing Order
		System.out.println("Placing Order");
		CustomerOrder juliaOrder = new CustomerOrder();
		juliaOrder.setOrderId("1");
		juliaOrder.setBillingAddress(juliaCicale.getBillingAddress());
		juliaOrder.setCustomer(juliaCicale);
		juliaOrder.setOrderState(AppBaseConstantsWeb.ORDER_STATUS_PENDING);
		juliaOrder.setPaymentStatus(AppBaseConstantsWeb.PAYMENT_STATUS_PENDING);

		// Adding items to the Order
		List<OrderDetail> orderDetails = new ArrayList<>();
		orderDetails.add(new ShippingOrder("1", searchFitbit.get(0), 1, AppBaseConstantsWeb.ORDER_STATUS_PENDING,
				juliaCicale.getShippingAddress()));
		orderDetails.add(new PickUpOrder("2", searchHeadphones.get(0), 2, AppBaseConstantsWeb.ORDER_STATUS_PENDING));
		juliaOrder.setOrderDetails(orderDetails);
		System.out.println("Total of Order is : " + juliaOrder.getTotal());
		// Adding Payment Method to the Order
		List<PaymentMethod> paymentMethods = new ArrayList<>();
		paymentMethods.add(new CreditCardPayment("1", AppBaseConstantsWeb.PAYMENT_STATUS_PENDING, 100.0,
				"1010101010101010101020", "Julia Cicale", "911", "20/20"));
		paymentMethods.add(new PayPalPayment("2", AppBaseConstantsWeb.PAYMENT_STATUS_PENDING, 190.0, "XVF1022",
				"julia.cicale@gmail.com"));
		juliaOrder.setPaymentMethod(paymentMethods);
		customerOrderService.save(juliaOrder);
		// Accept Payment
		customerOrderService.acceptPayment(juliaOrder);
		// Fulfill Order
		customerOrderService.fulfillOrder(juliaOrder);
		// Ship Fitbit Order
		orderDetailService.shipOrderDetail((ShippingOrder) orderDetails.get(0), "9999999999999999999");
		// Cancel HeadPhones Order
		customerOrderService.cancelOrderDetail(juliaOrder, orderDetails.get(1));
		// Write Review for Order of Fitbit
		List<Review> reviewsFitbit = new ArrayList<>();
		reviewsFitbit.add(new Review("1", "Excellent Activity Tracker",
				"Small and stylish, very accurate on with the step count.", 5, juliaCicale));
		fitbitAlta.setReview(reviewsFitbit);
		productService.save(fitbitAlta);
		return "index";
	}

}