package com.ebook.service.order;

import java.util.List;

import com.ebook.model.order.CustomerOrder;
import com.ebook.model.order.OrderDetail;

public interface CustomerOrderService {
	public CustomerOrder save(CustomerOrder customerOrder);

	public List<CustomerOrder> listAll();

	public CustomerOrder getById(String customerOrderId);

	public boolean remove(CustomerOrder customerOrder);

	public boolean acceptPayment(CustomerOrder customerOrder);

	public boolean fulfillOrder(CustomerOrder customerOrder);

	public boolean cancelOrderDetail(CustomerOrder customerOrder, OrderDetail orderDetail);
}
