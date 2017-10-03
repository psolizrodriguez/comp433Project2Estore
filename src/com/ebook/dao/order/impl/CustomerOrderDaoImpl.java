package com.ebook.dao.order.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ebook.common.dao.AbstractBaseDao;
import com.ebook.dao.order.CustomerOrderDao;
import com.ebook.model.order.CustomerOrder;

@SuppressWarnings("rawtypes")
@Repository
public class CustomerOrderDaoImpl extends AbstractBaseDao implements CustomerOrderDao {

	@SuppressWarnings("unchecked")
	@Transactional
	public CustomerOrder save(CustomerOrder customerOrder) {
		return (CustomerOrder) super.store(customerOrder);
	}

	public List<CustomerOrder> listAll() {
		return super.verifyListNamedQueryAll("com.ebook.dao.customerOrder.impl.CustomerOrderDaoImpl.listAll");
	}

	@Transactional
	public boolean remove(CustomerOrder customerOrder) {
		return super.remove(customerOrder);

	}

	@Override
	public CustomerOrder getById(String customerOrderId) {
		return super.verifyNamedQueryAll("com.ebook.dao.customerOrder.impl.CustomerOrderDaoImpl.getById",
				customerOrderId);
	}
}