package com.ebook.view;

import java.util.List;

import com.ebook.model.customer.Address;
import com.ebook.model.customer.Customer;
import com.ebook.model.item.Book;
import com.ebook.model.order.Order;
import com.ebook.model.order.OrderDetail;

public class BookStoreClient {
			
		public static void main (String args[]) throws Exception {
						
	        Customer customer = new Customer();;
			customer.setFirstName("Michael");
	        customer.setLastName("Gerard");
	        customer.setCustomerId("AY2345");
	        Address billingAddress = new Address();
	        billingAddress.setStreet("500 West Madison St.");
	        billingAddress.setUnit("Suite 1000");
	        billingAddress.setCity("Chicago");
	        billingAddress.setState("IL");
	        billingAddress.setZip("66610");
	        customer.setBillingAddress(billingAddress);

	        //Create order for the customer
	        Order order1 = new Order();
	        order1.setOrderId("BO-66734");

	        //Associate the order with the customer
	        customer.addOrder(order1);
	        
	        //order detail contains products ordered
	        //First product
	        Book product1 = new Book();
	        product1.setId("BF-7898");
	        product1.setISBN("234-89675-27690");
	        product1.setTitle("Patterns of Enterprise Application Architecture");
	        product1.setAuthor("Folwer, Martin");
	        product1.setPrice(50.99);
	        //Add product to order
	        order1.addProduct(product1, 1);
	        
	        //Second product
	        Book product2 = new Book();
	        product2.setId("BF-2345");
	        product2.setISBN("892-12345-93667");
	        product2.setTitle("Web Application Architecture");
	        product2.setAuthor("Shklar, Leon");
	        product2.setPrice(45.99);
	        //Add the products detail to Order
	        order1.addProduct(product2, 1);
	        
	        //finish order	        
	        order1.confirmOrder();
	        order1.orderPayed();
	        
	        // NOTE: To cancel the request, un-comment the following line.
	        //order.cancel();
	        
	        // Then, comment out the next 2 lines.
	        order1.orderSendOut();
	        order1.orderDelivered();
	        
	        // Print out an order summary
	        Address billingAdd = customer.getBillingAddress();
	        List<OrderDetail> orderLines = order1.getOrderDetails();
	        double orderTotal = order1.getOrderTotal();

	        // Format order output
	        System.out.println("\tOrder Id: \t\t" + order1.getOrderId() + "\n");
	        System.out.println("\tOrder status: \t\t" + order1.getOrderState() + "\n");
	        System.out.println("\tName: \t\t\t" + customer.getFirstName() + " " + customer.getLastName() + "\n");

	        System.out.println("\tBilling Address:\t" + billingAdd.getStreet() + 
	        		"\n\t\t\t\t" + billingAdd.getUnit() + 
	        		"\n\t\t\t\t" + billingAdd.getCity() + ", " + 
	        		billingAdd.getState() + " " + billingAdd.getZip() +
	        		"\n");

	        System.out.println("\tOrder Items: ");
	        for (OrderDetail line : orderLines) {
	        	System.out.println("\t\t\t\t" + line.getProduct().getTitle() + "\t" + 
	        			line.getProduct().getPrice() + " x " + line.getQuantity());
	        }

	        System.out.println("\n\tOrder Total:\t\t" + orderTotal);
	        
		}

}
