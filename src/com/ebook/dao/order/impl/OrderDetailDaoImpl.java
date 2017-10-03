package com.ebook.dao.order.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ebook.common.dao.AbstractBaseDao;
import com.ebook.dao.order.OrderDetailDao;
import com.ebook.model.order.OrderDetail;

@SuppressWarnings("rawtypes")
@Repository
public class OrderDetailDaoImpl extends AbstractBaseDao implements OrderDetailDao {

	@SuppressWarnings("unchecked")
	@Transactional
	public OrderDetail save(OrderDetail orderDetail) {
		return (OrderDetail) super.store(orderDetail);
	}

	public List<OrderDetail> listAll() {
		return super.verifyListNamedQueryAll("com.ebook.dao.orderDetail.impl.OrderDetailDaoImpl.listAll");
	}

	@Transactional
	public boolean remove(OrderDetail orderDetail) {
		return super.remove(orderDetail);

	}

	@Override
	public OrderDetail getById(String orderDetailId) {
		return super.verifyNamedQueryAll("com.ebook.dao.orderDetail.impl.OrderDetailDaoImpl.getById", orderDetailId);
	}
}