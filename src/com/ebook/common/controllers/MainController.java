package com.ebook.common.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ebook.common.utility.AppBaseUtilsWeb;
import com.ebook.model.customer.Address;
import com.ebook.model.customer.Customer;
import com.ebook.model.item.Book;
import com.ebook.model.item.Inventory;
import com.ebook.model.item.Partner;
import com.ebook.model.item.Product;
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
		Customer juliaCicale = customerService.getById(Long.valueOf(1));
		if (juliaCicale == null) {
			juliaCicale = customerService.save(
					new Customer(null, "Cicale", "Julia", "julia.cicale", AppBaseUtilsWeb.encriptText("julia.cicale"),
							new Address(null, "123 Home St.", "Unit 2", "Chicago", "IL", "60657"),
							new Address(null, "123 Business Rd.", "Ste 500", "Chicago", "IL", "60601")));
			// Adding products
			System.out.println("Adding Product FitBit Alta");
			Product fitbitAlta = productService.save(new Product(null, "FitBit Alta", "Activity Tracker", null));
			System.out.println("Adding Product Bluetooth Headphones");
			Product headphones = productService.save(
					new Product(null, "Bluetooth Headphones", "Wireless and comfortable headphones for running", null));
			System.out.println("Adding Product Laptop Bag");
			Product laptopBag = productService
					.save(new Product(null, "Laptop Bag", "Fits laptops of up to 15 inches", null));
			Book odyssey = (Book) productService.save(new Book(null, "The Odyssey",
					"Sing to me of the man, Muse, the man of twists and turns driven time and again off course, once he had plundered the hallowed heights of Troy",
					null, "9785040381791", "Homer"));
			// Adding Partners
			System.out.println("Adding Partner Amazon");
			Partner amazon = partnerService
					.save(new Partner(null, "Amazon", "amazon", AppBaseUtilsWeb.encriptText("amazon12345")));
			Inventory amazonInv_1 = inventoryService.save(new Inventory(null, amazon, fitbitAlta, 150.0, 10));
			Inventory amazonInv_2 = inventoryService.save(new Inventory(null, amazon, headphones, 80.0, 10));
			Inventory amazonInv_3 = inventoryService.save(new Inventory(null, amazon, laptopBag, 15.0, 10));
			Inventory amazonInv_4 = inventoryService.save(new Inventory(null, amazon, odyssey, 40.0, 10));

			System.out.println("Adding Partner Ebay");
			Partner ebay = partnerService
					.save(new Partner(null, "Ebay", "ebay", AppBaseUtilsWeb.encriptText("ebay12345")));
			Inventory ebayInv_1 = inventoryService.save(new Inventory(null, ebay, fitbitAlta, 160.0, 15));
			Inventory ebayInv_2 = inventoryService.save(new Inventory(null, ebay, headphones, 70.0, 15));
			Inventory ebayInv_3 = inventoryService.save(new Inventory(null, ebay, laptopBag, 20.0, 15));
			Inventory ebayInv_4 = inventoryService.save(new Inventory(null, ebay, odyssey, 40.0, 15));
		}

		// Searching for Inventory
		/*
		 * System.out.println("Searching for Inventory"); List<Inventory> searchFitbit =
		 * inventoryService.listAllInventoryByKeywords("FitBit"); if
		 * (searchFitbit.size() > 0) { for (Inventory inventory : searchFitbit) {
		 * System.out.println(inventory.getProduct().getTitle() + "(" +
		 * inventory.getProduct().getProductId() + "), " + inventory.getQuantity() +
		 * " available @ " + inventory.getPrice()); } } else {
		 * System.out.println("No records Found"); }
		 * System.out.println("Searching for Inventory"); List<Inventory>
		 * searchHeadphones = inventoryService.listAllInventoryByKeywords("Headphones");
		 * if (searchHeadphones.size() > 0) { for (Inventory inventory :
		 * searchHeadphones) { System.out.println(inventory.getProduct().getTitle() +
		 * "(" + inventory.getProduct().getProductId() + "), " + inventory.getQuantity()
		 * + " available @ " + inventory.getPrice()); } } else {
		 * System.out.println("No records Found"); } // Placing Order
		 * System.out.println("Placing Order"); CustomerOrder juliaOrder = new
		 * CustomerOrder(); juliaOrder.setOrderId(1L);
		 * juliaOrder.setBillingAddress(juliaCicale.getBillingAddress());
		 * juliaOrder.setCustomer(juliaCicale);
		 * juliaOrder.setOrderState(AppBaseConstantsWeb.ORDER_STATUS_PENDING);
		 * juliaOrder.setPaymentStatus(AppBaseConstantsWeb.PAYMENT_STATUS_PENDING);
		 * 
		 * // Adding items to the Order List<OrderDetail> orderDetails = new
		 * ArrayList<>(); orderDetails.add(new ShippingOrder(1L, searchFitbit.get(0), 1,
		 * AppBaseConstantsWeb.ORDER_STATUS_PENDING, juliaCicale.getShippingAddress(),
		 * null)); orderDetails.add(new PickUpOrder(2L, searchHeadphones.get(0), 2,
		 * AppBaseConstantsWeb.ORDER_STATUS_PENDING));
		 * juliaOrder.setOrderDetails(orderDetails);
		 * System.out.println("Total of Order is : " + juliaOrder.getTotal()); // Adding
		 * Payment Method to the Order List<PaymentMethod> paymentMethods = new
		 * ArrayList<>(); paymentMethods.add(new CreditCardPayment(1L,
		 * AppBaseConstantsWeb.PAYMENT_STATUS_PENDING, 100.0, "1010101010101010101020",
		 * "Julia Cicale", "911", "20/20")); paymentMethods.add(new PayPalPayment(2L,
		 * AppBaseConstantsWeb.PAYMENT_STATUS_PENDING, 190.0, "XVF1022",
		 * "julia.cicale@gmail.com")); juliaOrder.setPaymentMethod(paymentMethods);
		 * juliaOrder = customerOrderService.save(juliaOrder); // Accept Payment
		 * customerOrderService.acceptPayment(juliaOrder); // Fulfill Order
		 * customerOrderService.fulfillOrder(juliaOrder); // Ship Fitbit Order
		 * orderDetailService.shipOrderDetail((ShippingOrder)
		 * juliaOrder.getOrderDetails().get(0), "9999999999999999999"); // Cancel
		 * HeadPhones Order customerOrderService.cancelOrderDetail(juliaOrder,
		 * juliaOrder.getOrderDetails().get(1)); // Write Review for Order of Fitbit
		 * List<Review> reviewsFitbit = new ArrayList<>(); reviewsFitbit.add(new
		 * Review(1L, "Excellent Activity Tracker",
		 * "Small and stylish, very accurate on with the step count.", 5, juliaCicale));
		 * fitbitAlta.setReview(reviewsFitbit); fitbitAlta =
		 * productService.save(fitbitAlta);
		 * 
		 * // Creating test Order System.out.println("Placing Order"); searchFitbit =
		 * inventoryService.listAllInventoryByKeywords("FitBit"); CustomerOrder order2 =
		 * new CustomerOrder(); order2.setOrderId(2L);
		 * order2.setBillingAddress(juliaCicale.getBillingAddress());
		 * order2.setCustomer(juliaCicale);
		 * order2.setOrderState(AppBaseConstantsWeb.ORDER_STATUS_PENDING);
		 * order2.setPaymentStatus(AppBaseConstantsWeb.PAYMENT_STATUS_PENDING);
		 * List<OrderDetail> orderDetails2 = new ArrayList<>(); orderDetails2.add(new
		 * ShippingOrder(3L, searchFitbit.get(0), 1,
		 * AppBaseConstantsWeb.ORDER_STATUS_PENDING, juliaCicale.getShippingAddress(),
		 * null)); order2.setOrderDetails(orderDetails2); List<PaymentMethod>
		 * paymentMethods2 = new ArrayList<>(); paymentMethods2.add(new
		 * CreditCardPayment(3L, AppBaseConstantsWeb.PAYMENT_STATUS_PENDING, 150.0,
		 * "1010101010101010101020", "Julia Cicale", "911", "20/20"));
		 * order2.setPaymentMethod(paymentMethods2); order2 =
		 * customerOrderService.save(order2);
		 * 
		 * // Creating test Order for fulfillOrder System.out.println("Placing Order");
		 * searchFitbit = inventoryService.listAllInventoryByKeywords("FitBit");
		 * CustomerOrder order3 = new CustomerOrder(); order3.setOrderId(3L);
		 * order3.setBillingAddress(juliaCicale.getBillingAddress());
		 * order3.setCustomer(juliaCicale);
		 * order3.setOrderState(AppBaseConstantsWeb.ORDER_STATUS_PENDING);
		 * order3.setPaymentStatus(AppBaseConstantsWeb.PAYMENT_STATUS_PENDING);
		 * List<OrderDetail> orderDetails3 = new ArrayList<>();
		 * 
		 * orderDetails3.add(new ShippingOrder(4L, searchFitbit.get(0), 1,
		 * AppBaseConstantsWeb.ORDER_STATUS_PENDING, juliaCicale.getShippingAddress(),
		 * null)); order3.setOrderDetails(orderDetails3); List<PaymentMethod>
		 * paymentMethods3 = new ArrayList<>(); paymentMethods3.add(new
		 * CreditCardPayment(4L, AppBaseConstantsWeb.PAYMENT_STATUS_PENDING, 150.0,
		 * "1010101010101010101020", "Julia Cicale", "911", "20/20"));
		 * order3.setPaymentMethod(paymentMethods3); order3 =
		 * customerOrderService.save(order3);
		 * customerOrderService.acceptPayment(order3);
		 * 
		 * // Creating test Order for shipOrder and cancelOrder
		 * System.out.println("Placing Order"); searchFitbit =
		 * inventoryService.listAllInventoryByKeywords("FitBit"); searchHeadphones =
		 * inventoryService.listAllInventoryByKeywords("Headphones"); CustomerOrder
		 * order4 = new CustomerOrder(); order4.setOrderId(4L);
		 * order4.setBillingAddress(juliaCicale.getBillingAddress());
		 * order4.setCustomer(juliaCicale);
		 * order4.setOrderState(AppBaseConstantsWeb.ORDER_STATUS_PENDING);
		 * order4.setPaymentStatus(AppBaseConstantsWeb.PAYMENT_STATUS_PENDING);
		 * List<OrderDetail> orderDetails4 = new ArrayList<>(); orderDetails4.add(new
		 * ShippingOrder(5L, searchFitbit.get(0), 1,
		 * AppBaseConstantsWeb.ORDER_STATUS_PENDING, juliaCicale.getShippingAddress(),
		 * null)); orderDetails4.add(new PickUpOrder(6L, searchHeadphones.get(0), 1,
		 * AppBaseConstantsWeb.ORDER_STATUS_PENDING));
		 * order4.setOrderDetails(orderDetails4); List<PaymentMethod> paymentMethods4 =
		 * new ArrayList<>(); paymentMethods4.add(new CreditCardPayment(5L,
		 * AppBaseConstantsWeb.PAYMENT_STATUS_PENDING, 220.0, "1010101010101010101020",
		 * "Julia Cicale", "911", "20/20")); order4.setPaymentMethod(paymentMethods4);
		 * order4 = customerOrderService.save(order4);
		 * customerOrderService.acceptPayment(order4);
		 * customerOrderService.fulfillOrder(order4);
		 */

		return "index";
	}

}