package com.ebook.view;

import com.ebook.model.customer.Address;
import com.ebook.model.customer.Customer;
import com.ebook.model.service.CustomerService;

public class BookStoreClient2 {
	public static void main (String args[]) throws Exception {
		
		//Client will use the customer service to have access to anything related to customer functionality.
	      System.out.println("*************** Creating Customer service object *************************");
		CustomerService custService = new CustomerService();    
/**
		System.out.println("BookStoreClient2: *************** instantiating a customer and its address *************************");
        Customer customer = new Customer();;
		customer.setFirstName("Jon");
        customer.setLastName("Wheatland");
        customer.setCustomerId("XY8888");
        Address billingAddress = new Address();
        billingAddress.setAddressId("AD9090");
        billingAddress.setStreet("500 West Madison St.");
        billingAddress.setUnit("Suite 1000");
        billingAddress.setCity("Chicago");
        billingAddress.setState("IL");
        billingAddress.setZip("66610");
        customer.setBillingAddress(billingAddress);
      
        //save customer information
        //Saving the newly created customer and its address
        custService.addCustomer(customer);
        
        System.out.println("BookStoreClient2: *************** Customer is inserted in BookStore Database *************************");
**/
         System.out.println("BookStoreClient2: *************** trying to search customer in the database *************************");
 
      //Find a customer if already exists; if not, create a new one.
      Customer searchedCustomer = custService.findCustomerById("XY8888"); 
      
      System.out.println("BookStoreClient2: *************** Here is searched customer information *************************");
        System.out.println("\tName: \t\t\t" + searchedCustomer.getFirstName() + " " + searchedCustomer.getLastName() + "\n");
        Address billingAdd = searchedCustomer.getBillingAddress();
        System.out.println("\tBilling Address:\t" + billingAdd.getAddressId() + 
        		"\n\t\t\t\t" + billingAdd.getStreet() +
        		"\n\t\t\t\t" + billingAdd.getUnit() + 
        		"\n\t\t\t\t" + billingAdd.getCity() + ", " + 
        		billingAdd.getState() + " " + billingAdd.getZip() +
        		"\n");
        
	}
}
