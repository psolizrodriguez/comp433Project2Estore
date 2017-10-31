package com.ebook.service.order;

import java.util.List;

import com.ebook.model.order.CustomerOrder;

public interface CustomerOrderService {
	public CustomerOrder save(CustomerOrder customerOrder);

	public List<CustomerOrder> listAll();

	public List<CustomerOrder> listAllOrdersByCustomerId(Long customerId);

	public List<CustomerOrder> listAllOrdersByCustomerId_OrderStatus(Long customerId, String orderStatus);

	public CustomerOrder getById(Long customerOrderId);

	public boolean remove(CustomerOrder customerOrder);

	public boolean acceptPayment(CustomerOrder customerOrder);

	public boolean fulfillOrder(CustomerOrder customerOrder);

	public boolean cancelOrderDetail(CustomerOrder customerOrder, Long orderDetailId);
}
