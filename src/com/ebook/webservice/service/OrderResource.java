package com.ebook.webservice.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebook.webservice.representation.CustomerOrderRepresentation;
import com.ebook.webservice.representation.InventoryRepresentation;
import com.ebook.webservice.workflow.OrderActivity;

@Component
@Path("/orderService/")
public class OrderResource implements OrderWebService {

	@Autowired
	OrderActivity orderActivity;

	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/searchInventoryofProduct")
	public List<InventoryRepresentation> getProducts(@QueryParam("keywords") String keywords) {
		System.out.println("GET METHOD Request for all products .............");
		return orderActivity.getProducts(keywords);
	}

	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/searchCustomerOrders")
	public List<CustomerOrderRepresentation> listAllOrdersByCustomerId(@QueryParam("customerId") long customerId,
			@QueryParam("orderState") String orderState) {
		if(orderState != null) {
			System.out.println("GET METHOD Request for customerId " + customerId + " with order status " + orderState + "......");
			return orderActivity.getOrdersByCustomerId_OrderState(customerId, orderState);
		} else {
			System.out.println("GET METHOD Request for customerId " + customerId + "......");
			return orderActivity.getOrdersByCustomerId(customerId);
		}
	}

}