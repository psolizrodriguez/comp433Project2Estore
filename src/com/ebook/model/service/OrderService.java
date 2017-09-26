package com.ebook.model.service;

import com.ebook.dal.OrderDAO;
import com.ebook.model.order.Order;

public class OrderService {
	private OrderDAO orderDAO = new OrderDAO();
	
	//search order by ID from the DB
		public Order findOrderById(int orderId) {
				
			try {
				Order order = orderDAO.getOrder(orderId);
				return order;
		    } catch (Exception se) {
		      System.err.println("OrderService: Threw an Exception retrieving order.");
		      System.err.println(se.getMessage());
		    }
			return null;
		}

}
