package com.ebook.webservice.workflow;

import java.util.List;

import com.ebook.webservice.representation.CustomerOrderRepresentation;
import com.ebook.webservice.representation.CustomerOrderRequest;
import com.ebook.webservice.representation.InventoryRepresentation;
import com.ebook.webservice.representation.ShipOrderDetailRequest;

public interface OrderActivity {

	public List<InventoryRepresentation> getProducts(String keywords);

	public List<CustomerOrderRepresentation> getOrdersByCustomerId_OrderState(Long customerId, String orderState);

	public CustomerOrderRepresentation createCustomerOrder(CustomerOrderRequest customerOrderRequest);
	
	public boolean acceptPayment(Long customerOrderId);

	public boolean fulfillOrder(Long customerOrderId);

	public boolean shipOrder(Long orderDetailId, ShipOrderDetailRequest shipOrderDetailRequest);

	public boolean cancelOrder(Long customerOrderId, Long orderDetailId);

}
