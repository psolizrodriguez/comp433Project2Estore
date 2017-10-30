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
	
	@Override
	public List<CustomerOrder> listAllByCustomerId(Long customerId) {
		return super.verifyListNamedQueryAll("com.ebook.dao.customerOrder.impl.CustomerOrderDaoImpl.listAllByCustomerId", customerId);
	}

	@Override
	public List<CustomerOrder> listAllByCustomerId_OrderStatus(Long customerId, String orderStatus) {
		return super.verifyListNamedQueryAll("com.ebook.dao.customerOrder.impl.CustomerOrderDaoImpl.listAllByCustomerId_OrderStatus", 
				customerId, orderStatus);
	}

	@Transactional
	public boolean remove(CustomerOrder customerOrder) {
		return super.remove(customerOrder);

	}

	@Override
	public CustomerOrder getById(Long customerOrderId) {
		return super.verifyNamedQueryAll("com.ebook.dao.customerOrder.impl.CustomerOrderDaoImpl.getById",
				customerOrderId);
	}


}