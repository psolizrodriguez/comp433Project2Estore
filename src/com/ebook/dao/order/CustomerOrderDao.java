package com.ebook.dao.order;

import java.util.List;

import com.ebook.common.dao.Dao;
import com.ebook.model.order.CustomerOrder;

public interface CustomerOrderDao extends Dao {
	public CustomerOrder save(CustomerOrder customerOrder);

	public List<CustomerOrder> listAll();

	public List<CustomerOrder> listAllByCustomerId(Long customerId);

	public List<CustomerOrder> listAllByCustomerId_OrderStatus(Long customerId, String orderStatus);

	public CustomerOrder getById(Long customerOrderId);

	public boolean remove(CustomerOrder customerOrder);

}
