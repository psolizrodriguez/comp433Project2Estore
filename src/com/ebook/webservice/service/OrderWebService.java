package com.ebook.webservice.service;

import java.util.List;

import javax.jws.WebService;

import com.ebook.webservice.representation.CustomerOrderRepresentation;
import com.ebook.webservice.representation.CustomerOrderRequest;
import com.ebook.webservice.representation.InventoryRepresentation;

@WebService
public interface OrderWebService {

	public List<InventoryRepresentation> getProducts(String keywords);

	public List<CustomerOrderRepresentation> listAllOrdersByCustomerId(Long customerId, String orderState);

	public CustomerOrderRepresentation createCustomerOrder(CustomerOrderRequest customerOrderRequest);

}
