package com.ebook.webservice.service;

import java.util.List;

import javax.jws.WebService;

import com.ebook.webservice.representation.CustomerOrderRepresentation;
import com.ebook.webservice.representation.CustomerOrderRequest;
import com.ebook.webservice.representation.InventoryRepresentation;
import com.ebook.webservice.representation.OrderDetailRepresentation;
import com.ebook.webservice.representation.ShipOrderDetailRequest;

@WebService
public interface OrderWebService {

	public List<InventoryRepresentation> searchInventoryofProduct(String keywords);

	public List<CustomerOrderRepresentation> listAllOrdersByCustomerId(Long customerId, String orderState);

	public CustomerOrderRepresentation createCustomerOrder(CustomerOrderRequest customerOrderRequest);
	
	public CustomerOrderRepresentation acceptPayment(Long customerOrderId);
	
	public CustomerOrderRepresentation fulfillOrder(Long customerOrderId);
	
	public OrderDetailRepresentation shipOrder(Long customerOrderId, Long customerOrderDetailId, ShipOrderDetailRequest shipOrderDetailRequest);

	public OrderDetailRepresentation cancelOrder(Long customerOrderId, Long customerOrderDetailId);

}
