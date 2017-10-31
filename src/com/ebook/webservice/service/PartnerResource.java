package com.ebook.webservice.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebook.webservice.representation.CancelOrderDetailRequest;
import com.ebook.webservice.representation.CustomerOrderRepresentation;
import com.ebook.webservice.representation.AcceptPaymentCustomerOrderRequest;
import com.ebook.webservice.representation.InventoryRepresentation;
import com.ebook.webservice.representation.InventoryRequest;
import com.ebook.webservice.representation.OrderDetailDeliveredRequest;
import com.ebook.webservice.representation.OrderDetailRepresentation;
import com.ebook.webservice.representation.PartnerRepresentation;
import com.ebook.webservice.representation.PartnerRequest;
import com.ebook.webservice.representation.ProductRepresentation;
import com.ebook.webservice.representation.ProductRequest;
import com.ebook.webservice.representation.ShipOrderDetailRequest;
import com.ebook.webservice.workflow.PartnerActivity;

@Component
@Path("/partnerService/")
public class PartnerResource implements PartnerWebService {

	@Autowired
	PartnerActivity partnerActivity;

	@PUT
	@Produces({ "application/xml", "application/json" })
	@Path("/acceptPayment")
	public CustomerOrderRepresentation acceptPayment(AcceptPaymentCustomerOrderRequest customerOrderRequest) {
		return partnerActivity.acceptPayment(customerOrderRequest);
	}

	@PUT
	@Produces({ "application/xml", "application/json" })
	@Path("/fulfillOrder")
	public CustomerOrderRepresentation fulfillOrder(AcceptPaymentCustomerOrderRequest customerOrderRequest) {
		return partnerActivity.fulfillOrder(customerOrderRequest);
	}

	@PUT
	@Produces({ "application/xml", "application/json" })
	@Path("/shipOrder")
	public OrderDetailRepresentation shipOrder(ShipOrderDetailRequest shipOrderDetailRequest) {
		return partnerActivity.shipOrder(shipOrderDetailRequest);
	}

	@PUT
	@Produces({ "application/xml", "application/json" })
	@Path("/cancelOrder")
	public OrderDetailRepresentation cancelOrder(CancelOrderDetailRequest cancelOrderDetailRequest) {
		return partnerActivity.cancelOrder(cancelOrderDetailRequest);
	}

	@POST
	@Produces({ "application/xml", "application/json" })
	@Path("/partner")
	public PartnerRepresentation createPartner(PartnerRequest partnerRequest) {
		System.out.println("POST METHOD Message");
		return partnerActivity.createPartner(partnerRequest);
	}

	@POST
	@Produces({ "application/xml", "application/json" })
	@Path("/inventory")
	public InventoryRepresentation createInventory(InventoryRequest inventoryRequest) {
		return partnerActivity.createInventory(inventoryRequest);
	}

	@POST
	@Produces({ "application/xml", "application/json" })
	@Path("/product")
	public ProductRepresentation createProduct(ProductRequest productRequest) {
		return partnerActivity.createProduct(productRequest);
	}

	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/searchOrderDetailByPartnerIdAndOrderState")
	public List<OrderDetailRepresentation> listAllOrderDetailByPartnerIdAndOrderState(
			@QueryParam("partnerId") Long partnerId, @QueryParam("orderState") String orderState) {
		return partnerActivity.listAllOrderDetailByPartnerIdAndOrderState(partnerId, orderState);
	}

	@PUT
	@Produces({ "application/xml", "application/json" })
	@Path("/markOrderAsDelivered")
	public OrderDetailRepresentation deliveredOrderDetail(OrderDetailDeliveredRequest orderDetailDeliveredRequest) {
		return partnerActivity.deliveredOrderDetail(orderDetailDeliveredRequest);
	}

}