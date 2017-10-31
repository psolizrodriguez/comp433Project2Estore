package com.ebook.webservice.workflow;

import java.util.List;

import com.ebook.webservice.representation.CustomerOrderRepresentation;
import com.ebook.webservice.representation.CustomerOrderRequest;
import com.ebook.webservice.representation.InventoryRepresentation;

public interface OrderActivity {

	public List<InventoryRepresentation> getProducts(String keywords);

	public List<CustomerOrderRepresentation> getOrdersByCustomerId(long customerId);

	public List<CustomerOrderRepresentation> getOrdersByCustomerId_OrderState(long customerId, String orderState);

	public CustomerOrderRepresentation createCustomerOrder(CustomerOrderRequest customerOrderRequest);

}
