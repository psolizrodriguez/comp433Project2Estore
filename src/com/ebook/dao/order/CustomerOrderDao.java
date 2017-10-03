package com.ebook.dao.order;

import java.util.List;

import com.ebook.common.dao.Dao;
import com.ebook.model.order.CustomerOrder;

public interface CustomerOrderDao extends Dao {
	public CustomerOrder save(CustomerOrder customerOrder);

	public List<CustomerOrder> listAll();

	public CustomerOrder getById(String customerOrderId);

	public boolean remove(CustomerOrder customerOrder);
}
