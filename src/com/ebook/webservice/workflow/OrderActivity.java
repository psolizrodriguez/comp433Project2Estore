package com.ebook.webservice.workflow;

import java.util.List;

import com.ebook.webservice.representation.CustomerOrderRepresentation;
import com.ebook.webservice.representation.CustomerOrderRequest;
import com.ebook.webservice.representation.InventoryRepresentation;
import com.ebook.webservice.representation.OrderDetailRepresentation;
import com.ebook.webservice.representation.ShipOrderDetailRequest;

public interface OrderActivity {

	public List<InventoryRepresentation> getProducts(String keywords);

	public List<CustomerOrderRepresentation> getOrdersByCustomerId_OrderState(Long customerId, String orderState);

	public CustomerOrderRepresentation createCustomerOrder(CustomerOrderRequest customerOrderRequest);
	
	public CustomerOrderRepresentation acceptPayment(Long customerOrderId);

	public CustomerOrderRepresentation fulfillOrder(Long customerOrderId);

	public OrderDetailRepresentation shipOrder(Long orderDetailId, ShipOrderDetailRequest shipOrderDetailRequest);

	public OrderDetailRepresentation cancelOrder(Long customerOrderId, Long orderDetailId);

}
