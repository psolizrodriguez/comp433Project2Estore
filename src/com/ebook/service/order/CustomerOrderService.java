package com.ebook.service.order;

import java.util.List;

import com.ebook.model.order.CustomerOrder;

public interface CustomerOrderService {
	public CustomerOrder save(CustomerOrder customerOrder);

	public List<CustomerOrder> listAll();

	public CustomerOrder getById(String customerOrderId);

	public boolean remove(CustomerOrder customerOrder);
}
