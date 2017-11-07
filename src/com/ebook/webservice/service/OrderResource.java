package com.ebook.webservice.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebook.webservice.representation.CustomerOrderRepresentation;
import com.ebook.webservice.representation.CustomerOrderRequest;
import com.ebook.webservice.representation.InventoryRepresentation;
import com.ebook.webservice.representation.OrderDetailRepresentation;
import com.ebook.webservice.representation.ShipOrderDetailRequest;
import com.ebook.webservice.workflow.OrderActivity;

@Component
@Path("/orderService/")
public class OrderResource implements OrderWebService {

	@Autowired
	OrderActivity orderActivity;

	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/searchInventoryofProduct")
	public List<InventoryRepresentation> searchInventoryofProduct(@QueryParam("keywords") String keywords) {
		List<InventoryRepresentation> listInventoryRepresentation = null;
		try {
			listInventoryRepresentation = orderActivity.getProducts(keywords);
		} catch (Exception e) {
			e.printStackTrace();
			listInventoryRepresentation = null;
		}
		return listInventoryRepresentation;
	}

	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/searchCustomerOrders")
	public List<CustomerOrderRepresentation> listAllOrdersByCustomerId(@QueryParam("customerId") Long customerId,
			@QueryParam("orderState") String orderState) {
		List<CustomerOrderRepresentation> listCustomerOrderRepresentation = null;
		try {
			listCustomerOrderRepresentation = orderActivity.getOrdersByCustomerId_OrderState(customerId, orderState);
		} catch (Exception e) {
			e.printStackTrace();
			listCustomerOrderRepresentation = null;
		}
		return listCustomerOrderRepresentation;
	}

	@POST
	@Produces({ "application/xml", "application/json" })
	@Path("/customerOrder")
	public CustomerOrderRepresentation createCustomerOrder(CustomerOrderRequest customerOrderRequest) {
		CustomerOrderRepresentation customerOrderRepresentation = null;
		try {
			customerOrderRepresentation = orderActivity.createCustomerOrder(customerOrderRequest);
		} catch (Exception e) {
			e.printStackTrace();
			customerOrderRepresentation = null;
		}
		return customerOrderRepresentation;
	}
	
	@PUT
	@Produces({ "application/xml", "application/json" })
	@Path("/customerOrder/{customerOrderId}/accept")
	public CustomerOrderRepresentation acceptPayment(@PathParam("customerOrderId") Long customerOrderId) {
		CustomerOrderRepresentation customerOrderRepresentation = null;
		try {
			customerOrderRepresentation = orderActivity.acceptPayment(customerOrderId);
		} catch (Exception e) {
			e.printStackTrace();
			customerOrderRepresentation = null;
		}
		return customerOrderRepresentation;
	}
	
	@PUT
	@Produces({ "application/xml", "application/json" })
	@Path("/customerOrder/{customerOrderId}/fulfill")
	public CustomerOrderRepresentation fulfillOrder(@PathParam("customerOrderId") Long customerOrderId) {
		CustomerOrderRepresentation customerOrderRepresentation = null;
		try {
			customerOrderRepresentation = orderActivity.fulfillOrder(customerOrderId);
		} catch (Exception e) {
			e.printStackTrace();
			customerOrderRepresentation = null;
		}
		return customerOrderRepresentation;
	}


	@PUT
	@Produces({ "application/xml", "application/json" })
	@Path("/customerOrder/{customerOrderId}/orderDetail/{customerOrderDetailId}/ship")
	public OrderDetailRepresentation shipOrder(@PathParam("customerOrderId") Long customerOrderId, @PathParam("customerOrderDetailId") Long customerOrderDetailId, ShipOrderDetailRequest shipOrderDetailRequest) {
		OrderDetailRepresentation orderDetailRepresentation = null;
		try {
			orderDetailRepresentation = orderActivity.shipOrder(customerOrderDetailId, shipOrderDetailRequest);
		} catch (Exception e) {
			e.printStackTrace();
			orderDetailRepresentation = null;
		}
		return orderDetailRepresentation;
	}
	 
	@PUT
	@Produces({ "application/xml", "application/json" })
	@Path("/customerOrder/{customerOrderId}/orderDetail/{customerOrderDetailId}/cancel")
	public OrderDetailRepresentation cancelOrder(@PathParam("customerOrderId") Long customerOrderId, @PathParam("customerOrderDetailId") Long customerOrderDetailId) {
		OrderDetailRepresentation orderDetailRepresentation = null;
		try {
			orderDetailRepresentation = orderActivity.cancelOrder(customerOrderId, customerOrderDetailId);
		} catch (Exception e) {
			e.printStackTrace();
			orderDetailRepresentation = null;
		}
		return orderDetailRepresentation;
	}

}