package com.ebook.webservice.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebook.webservice.representation.CustomerOrderRepresentation;
import com.ebook.webservice.representation.CustomerOrderRequest;
import com.ebook.webservice.representation.InventoryRepresentation;
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
	public List<InventoryRepresentation> getProducts(@QueryParam("keywords") String keywords) {
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
	public Response acceptPayment(@PathParam("customerOrderId") Long customerOrderId) {
		try {
			if (orderActivity.acceptPayment(customerOrderId)) {
				return Response.status(Status.OK).build();
			} else {
				return Response.status(Status.BAD_REQUEST).build();
			}
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PUT
	@Produces({ "application/xml", "application/json" })
	@Path("/customerOrder/{customerOrderId}/fulfill")
	public Response fulfillOrder(@PathParam("customerOrderId") Long customerOrderId) {
		try {
			if (orderActivity.fulfillOrder(customerOrderId)) {
				return Response.status(Status.OK).build();
			} else {
				return Response.status(Status.BAD_REQUEST).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}


	@PUT
	@Produces({ "application/xml", "application/json" })
	@Path("/customerOrder/{customerOrderId}/orderDetail/{customerOrderDetailId}/ship")
	public Response shipOrder(@PathParam("customerOrderId") Long customerOrderId, @PathParam("customerOrderDetailId") Long customerOrderDetailId, ShipOrderDetailRequest shipOrderDetailRequest) {
		try {
			if (orderActivity.shipOrder(customerOrderDetailId, shipOrderDetailRequest)) {
				return Response.status(Status.OK).build();
			} else {
				return Response.status(Status.BAD_REQUEST).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	 
	@PUT
	@Produces({ "application/xml", "application/json" })
	@Path("/customerOrder/{customerOrderId}/orderDetail/{customerOrderDetailId}/cancel")
	public Response cancelOrder(@PathParam("customerOrderId") Long customerOrderId, @PathParam("customerOrderDetailId") Long customerOrderDetailId) {
		try {
			if (orderActivity.cancelOrder(customerOrderId, customerOrderDetailId)) {
				return Response.status(Status.OK).build();
			} else {
				return Response.status(Status.BAD_REQUEST).build();
			}
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

}