package com.ebook.common.controllers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ebook.common.constants.AppBaseConstantsWeb;
import com.ebook.common.utility.AppBaseUtilsWeb;
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
		juliaCicale.setCustomerId(1L);
		juliaCicale.setFirstName("Julia");
		juliaCicale.setLastName("Cicale");
		juliaCicale.setUserName("julia.cicale");
		juliaCicale.setPassword(AppBaseUtilsWeb.encriptText("julia.cicale"));
		Address juliaShip = new Address();
		juliaShip.setAddressId(1L);
		juliaShip.setStreet("123 Home St.");
		juliaShip.setUnit("Unit 2");
		juliaShip.setCity("Chicago");
		juliaShip.setState("IL");
		juliaShip.setZip("60657");
		Address juliaBill = new Address();
		juliaBill.setAddressId(2L);
		juliaBill.setStreet("123 Business Rd.");
		juliaBill.setUnit("Ste 500");
		juliaBill.setCity("Chicago");
		juliaBill.setState("IL");
		juliaBill.setZip("60601");
		juliaCicale.setShippingAddress(juliaShip);
		juliaCicale.setBillingAddress(juliaBill);
		juliaCicale = customerService.save(juliaCicale);
		// Adding products
		System.out.println("Adding Product FitBit Alta");
		Product fitbitAlta = new Product();
		fitbitAlta.setProductId(1L);
		fitbitAlta.setTitle("FitBit Alta");
		fitbitAlta.setDescription("Activity Tracker");
		fitbitAlta = productService.save(fitbitAlta);
		System.out.println("Adding Product Bluetooth Headphones");
		Product headphones = new Product();
		headphones.setProductId(2L);
		headphones.setTitle("Bluetooth Headphones");
		headphones.setDescription("Wireless and comfortable headphones for running");
		headphones = productService.save(headphones);
		System.out.println("Adding Product Laptop Bag");
		Product laptopBag = new Product();
		laptopBag.setProductId(3L);
		laptopBag.setTitle("Laptop Bag");
		laptopBag.setDescription("Fits laptops of up to 15 inches");
		laptopBag = productService.save(laptopBag);
		Book odyssey = new Book();
		odyssey.setProductId(4L);
		odyssey.setTitle("The Odyssey");
		odyssey.setDescription(
				"Sing to me of the man, Muse, the man of twists and turns driven time and again off course, once he had plundered the hallowed heights of Troy");
		odyssey.setISBN("9785040381791");
		odyssey.setAuthor("Homer");
		odyssey = (Book) productService.save(odyssey);
		// Adding Partners
		System.out.println("Adding Partner Amazon");
		Partner amazon = new Partner();
		amazon.setPartnerId(1L);
		amazon.setName("Amazon");
		amazon.setUserName("amazon");
		amazon.setPassword(AppBaseUtilsWeb.encriptText("amazon12345"));
		List<Inventory> amazonInventory = new LinkedList<>();
		amazonInventory.add(new Inventory(1L, fitbitAlta, 150.0, 10));
		amazonInventory.add(new Inventory(2L, headphones, 80.0, 10));
		amazonInventory.add(new Inventory(3L, laptopBag, 15.0, 10));
		amazon.setInventory(amazonInventory);
		amazon = partnerService.save(amazon);
		System.out.println("Adding Partner Ebay");
		Partner ebay = new Partner();
		ebay.setPartnerId(2L);
		ebay.setName("Ebay");
		ebay.setUserName("ebay");
		ebay.setPassword(AppBaseUtilsWeb.encriptText("ebay12345"));
		List<Inventory> ebayInventory = new LinkedList<>();
		ebayInventory.add(new Inventory(4L, fitbitAlta, 160.0, 15));
		ebayInventory.add(new Inventory(5L, headphones, 70.0, 15));
		ebayInventory.add(new Inventory(6L, laptopBag, 20.0, 15));
		ebay.setInventory(ebayInventory);
		ebay = partnerService.save(ebay);
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
		juliaOrder.setOrderId(1L);
		juliaOrder.setBillingAddress(juliaCicale.getBillingAddress());
		juliaOrder.setCustomer(juliaCicale);
		juliaOrder.setOrderState(AppBaseConstantsWeb.ORDER_STATUS_PENDING);
		juliaOrder.setPaymentStatus(AppBaseConstantsWeb.PAYMENT_STATUS_PENDING);

		// Adding items to the Order
		List<OrderDetail> orderDetails = new ArrayList<>();
		orderDetails.add(new ShippingOrder(1L, searchFitbit.get(0), 1, AppBaseConstantsWeb.ORDER_STATUS_PENDING,
				juliaCicale.getShippingAddress()));
		orderDetails.add(new PickUpOrder(2L, searchHeadphones.get(0), 2, AppBaseConstantsWeb.ORDER_STATUS_PENDING));
		juliaOrder.setOrderDetails(orderDetails);
		System.out.println("Total of Order is : " + juliaOrder.getTotal());
		// Adding Payment Method to the Order
		List<PaymentMethod> paymentMethods = new ArrayList<>();
		paymentMethods.add(new CreditCardPayment(1L, AppBaseConstantsWeb.PAYMENT_STATUS_PENDING, 100.0,
				"1010101010101010101020", "Julia Cicale", "911", "20/20"));
		paymentMethods.add(new PayPalPayment(2L, AppBaseConstantsWeb.PAYMENT_STATUS_PENDING, 190.0, "XVF1022",
				"julia.cicale@gmail.com"));
		juliaOrder.setPaymentMethod(paymentMethods);
		juliaOrder = customerOrderService.save(juliaOrder);
		// Accept Payment
		customerOrderService.acceptPayment(juliaOrder);
		// Fulfill Order
		customerOrderService.fulfillOrder(juliaOrder);
		// Ship Fitbit Order
		orderDetailService.shipOrderDetail((ShippingOrder) juliaOrder.getOrderDetails().get(0), "9999999999999999999");
		// Cancel HeadPhones Order
		customerOrderService.cancelOrderDetail(juliaOrder, juliaOrder.getOrderDetails().get(1));
		// Write Review for Order of Fitbit
		List<Review> reviewsFitbit = new ArrayList<>();
		reviewsFitbit.add(new Review(1L, "Excellent Activity Tracker",
				"Small and stylish, very accurate on with the step count.", 5, juliaCicale));
		fitbitAlta.setReview(reviewsFitbit);
		fitbitAlta = productService.save(fitbitAlta);
		
		//Creating test Order
		System.out.println("Placing Order");
		searchFitbit = inventoryService.listAllInventoryByKeywords("FitBit");
		CustomerOrder order2 = new CustomerOrder();
		order2.setOrderId(2L);
		order2.setBillingAddress(juliaCicale.getBillingAddress());
		order2.setCustomer(juliaCicale);
		order2.setOrderState(AppBaseConstantsWeb.ORDER_STATUS_PENDING);
		order2.setPaymentStatus(AppBaseConstantsWeb.PAYMENT_STATUS_PENDING);
		List<OrderDetail> orderDetails2 = new ArrayList<>();
		orderDetails2.add(new ShippingOrder(3L, searchFitbit.get(0), 1, AppBaseConstantsWeb.ORDER_STATUS_PENDING,
				juliaCicale.getShippingAddress()));
		order2.setOrderDetails(orderDetails2);
		List<PaymentMethod> paymentMethods2 = new ArrayList<>();
		paymentMethods2.add(new CreditCardPayment(3L, AppBaseConstantsWeb.PAYMENT_STATUS_PENDING, 150.0,
				"1010101010101010101020", "Julia Cicale", "911", "20/20"));
		order2.setPaymentMethod(paymentMethods2);
		order2 = customerOrderService.save(order2);
	
		//Creating test Order for fulfillOrder
		System.out.println("Placing Order");
		searchFitbit = inventoryService.listAllInventoryByKeywords("FitBit");
		CustomerOrder order3 = new CustomerOrder();
		order3.setOrderId(3L);
		order3.setBillingAddress(juliaCicale.getBillingAddress());
		order3.setCustomer(juliaCicale);
		order3.setOrderState(AppBaseConstantsWeb.ORDER_STATUS_PENDING);
		order3.setPaymentStatus(AppBaseConstantsWeb.PAYMENT_STATUS_PENDING);
		List<OrderDetail> orderDetails3 = new ArrayList<>();
		
		orderDetails3.add(new ShippingOrder(4L, searchFitbit.get(0), 1, AppBaseConstantsWeb.ORDER_STATUS_PENDING,
				juliaCicale.getShippingAddress()));
		order3.setOrderDetails(orderDetails3);
		List<PaymentMethod> paymentMethods3 = new ArrayList<>();
		paymentMethods3.add(new CreditCardPayment(4L, AppBaseConstantsWeb.PAYMENT_STATUS_PENDING, 150.0,
				"1010101010101010101020", "Julia Cicale", "911", "20/20"));
		order3.setPaymentMethod(paymentMethods3);
		order3 = customerOrderService.save(order3);
		customerOrderService.acceptPayment(order3);
		
		//Creating test Order for shipOrder and cancelOrder
		System.out.println("Placing Order");
		searchFitbit = inventoryService.listAllInventoryByKeywords("FitBit");
		searchHeadphones = inventoryService.listAllInventoryByKeywords("Headphones");
		CustomerOrder order4 = new CustomerOrder();
		order4.setOrderId(4L);
		order4.setBillingAddress(juliaCicale.getBillingAddress());
		order4.setCustomer(juliaCicale);
		order4.setOrderState(AppBaseConstantsWeb.ORDER_STATUS_PENDING);
		order4.setPaymentStatus(AppBaseConstantsWeb.PAYMENT_STATUS_PENDING);
		List<OrderDetail> orderDetails4 = new ArrayList<>();
		orderDetails4.add(new ShippingOrder(5L, searchFitbit.get(0), 1, AppBaseConstantsWeb.ORDER_STATUS_PENDING,
				juliaCicale.getShippingAddress()));
		orderDetails4.add(new PickUpOrder(6L, searchHeadphones.get(0), 1, AppBaseConstantsWeb.ORDER_STATUS_PENDING));
		order4.setOrderDetails(orderDetails4);
		List<PaymentMethod> paymentMethods4 = new ArrayList<>();
		paymentMethods4.add(new CreditCardPayment(5L, AppBaseConstantsWeb.PAYMENT_STATUS_PENDING, 220.0,
				"1010101010101010101020", "Julia Cicale", "911", "20/20"));
		order4.setPaymentMethod(paymentMethods4);
		order4 = customerOrderService.save(order4);
		customerOrderService.acceptPayment(order4);
		customerOrderService.fulfillOrder(order4);
		
		return "index";
	}

}