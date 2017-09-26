package com.ebook.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.ebook.model.order.Order;

public class OrderDAO {
	public OrderDAO() {}
	
	public Order getOrder(int orderId) {
		try {
			Statement st = DBHelper.getConnection().createStatement();
			String selectOrderQuery = "SELECT order_id, payment_received, order_state "
	    			+ "FROM Orders WHERE order_id = '" + orderId + "'";
			ResultSet orderRS = st.executeQuery(selectOrderQuery);      
			System.out.println("OrderDAO: *************** Query " + selectOrderQuery);
			
			Order order = new Order();
			while(orderRS.next()) {
				order.setOrderId(orderRS.getInt("order_id"));
				order.setPaymentReceived(orderRS.getBoolean("payment_received"));
				order.setOrderState(orderRS.getString("order_state"));				
			}
			return order;
			
		}
		catch (SQLException se) {
		      System.err.println("CustomerDAO: Threw a SQLException retrieving the customer object.");
		      System.err.println(se.getMessage());
		      se.printStackTrace();
		    }
		return null;
	}
}
