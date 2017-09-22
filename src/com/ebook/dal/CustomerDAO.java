package com.ebook.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.ebook.model.customer.Address;
import com.ebook.model.customer.Customer;

public class CustomerDAO {
	public CustomerDAO() {}
	
	public Customer getCustomer(String customerId) {		
		  try { 		
	    	//Get Customer
	    	Statement st = DBHelper.getConnection().createStatement();
	    	String selectCustomerQuery = "SELECT customer_id, last_name, first_name, username, password "
	    			+ "FROM Customer WHERE customer_id = '" + customerId + "'";

	    	ResultSet custRS = st.executeQuery(selectCustomerQuery);      
	    	System.out.println("CustomerDAO: *************** Query " + selectCustomerQuery);
	    	
	      //Get Customer
    	  Customer customer = new Customer();
	      while ( custRS.next() ) {
	    	  customer.setCustomerId(custRS.getString("customer_id"));
	    	  customer.setLastName(custRS.getString("last_name"));
	    	  customer.setFirstName(custRS.getString("first_name"));
	    	  customer.setUserName(custRS.getString("username"));
	    	  customer.setPassword(custRS.getString("password"));
	      }
	      //close to manage resources
	      custRS.close();
	     //Get Billing Address
	      String selectBillingAddress = "SELECT customer_id, address_id, type, status FROM CustomerAddresses WHERE customer_id = 'A002' AND type = '1' AND status = 'Active'";
	      ResultSet addRS = st.executeQuery(selectBillingAddress);
	      if(addRS.next()) {
	    	  
	    	  Address billingAddress =new Address();
	    	  billingAddress.setAddressId(addRS.getInt("address_id"));
	    	  String billingAddressSelect ="SELECT address_id, street,unit,city,state,zip FROM Address WHERE address_id = " + billingAddress.getAddressId();
	    	  ResultSet addRSBilling = st.executeQuery(billingAddressSelect);
	    	  if(addRSBilling.next()) {
		    	  billingAddress.setCity(addRSBilling.getString("city"));
		    	  billingAddress.setStreet(addRSBilling.getString("street"));
		    	  billingAddress.setState(addRSBilling.getString("state"));
		    	  billingAddress.setZip(addRSBilling.getString("zip"));
		    	  billingAddress.setUnit(addRSBilling.getString("unit"));
		      }
	    	  addRSBilling.close();
	    	  customer.setBillingAddress(billingAddress);
	      }
	      addRS.close();
	      
	      /*	    		  
	      //Get Address
	      String selectAddressQuery = "SELECT addressID, street, unit, city, state, zip FROM Address WHERE customerID = '" + customerId + "'";
	      ResultSet addRS = st.executeQuery(selectAddressQuery);
    	  Address address = new Address();
    	  
    	  System.out.println("CustomerDAO: *************** Query " + selectAddressQuery);
    	  
	      while ( addRS.next() ) {
	    	  address.setAddressId(addRS.getString("addressid"));
	    	  address.setStreet(addRS.getString("street"));
	    	  address.setUnit(addRS.getString("unit"));
	    	  address.setCity(addRS.getString("city"));
	    	  address.setState(addRS.getString("state"));
	    	  address.setZip(addRS.getString("zip"));
	      }
	      
	      customer.setBillingAddress(address);
	      //close to manage resources
	      addRS.close();
	      st.close();
	      */
	      return customer;
	    }	    
	    catch (SQLException se) {
	      System.err.println("CustomerDAO: Threw a SQLException retrieving the customer object.");
	      System.err.println(se.getMessage());
	      se.printStackTrace();
	    }
	    return null;
	  }
	
	public void addCustomer(Customer cust) {
		/*Connection con = DBHelper.getConnection();
        PreparedStatement custPst = null;
        PreparedStatement addPst = null;

        try {
        	//Insert the customer object
            String custStm = "INSERT INTO Customer(customerID, lname, fname) VALUES(?, ?, ?)";
            custPst = con.prepareStatement(custStm);
            custPst.setString(1, cust.getCustomerId());
            custPst.setString(2, cust.getLastName());       
            custPst.setString(3, cust.getFirstName()); 
            custPst.executeUpdate();

        	//Insert the customer address object
            String addStm = "INSERT INTO Address(customerID, addressID, street, unit, city, state, zip) VALUES(?, ?, ?, ?, ?, ?, ?)";
            addPst = con.prepareStatement(addStm);
            addPst.setString(1, cust.getCustomerId());
            addPst.setString(2, cust.getBillingAddress().getAddressId());  
            addPst.setString(3, cust.getBillingAddress().getStreet());       
            addPst.setString(4, cust.getBillingAddress().getUnit());  
            addPst.setString(5, cust.getBillingAddress().getCity());  
            addPst.setString(6, cust.getBillingAddress().getState());      
            addPst.setString(7, cust.getBillingAddress().getZip());  
            addPst.executeUpdate();
        } catch (SQLException ex) {

        } finally {

            try {
                if (addPst != null) {
                	addPst.close();
                	custPst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
      	      System.err.println("CustomerDAO: Threw a SQLException saving the customer object.");
    	      System.err.println(ex.getMessage());
            }
        }*/
    }
}
