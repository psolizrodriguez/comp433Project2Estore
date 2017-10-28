package com.ebook.dao.order;

import java.util.List;

import com.ebook.common.dao.Dao;
import com.ebook.model.order.OrderDetail;

public interface OrderDetailDao extends Dao {
	public OrderDetail save(OrderDetail orderDetail);

	public List<OrderDetail> listAll();

	public OrderDetail getById(Long orderDetailId);

	public boolean remove(OrderDetail orderDetail);
}
