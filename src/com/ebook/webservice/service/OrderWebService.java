package com.ebook.webservice.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.ebook.webservice.representation.CustomerOrderRepresentation;
import com.ebook.webservice.representation.CustomerOrderRequest;
import com.ebook.webservice.representation.InventoryRepresentation;
import com.ebook.webservice.representation.ShipOrderDetailRequest;

@WebService
public interface OrderWebService {

	public List<InventoryRepresentation> getProducts(String keywords);

	public List<CustomerOrderRepresentation> listAllOrdersByCustomerId(Long customerId, String orderState);

	public CustomerOrderRepresentation createCustomerOrder(CustomerOrderRequest customerOrderRequest);
	
	public Response acceptPayment(Long customerOrderId);
	
	public Response fulfillOrder(Long customerOrderId);
	
	public Response shipOrder(Long customerOrderId, Long customerOrderDetailId, ShipOrderDetailRequest shipOrderDetailRequest);

	public Response cancelOrder(Long customerOrderId, Long customerOrderDetailId);

}
