package com.ebook.service.order;

import java.util.List;

import com.ebook.model.order.OrderDetail;
import com.ebook.model.order.ShippingOrder;

public interface OrderDetailService {
	public OrderDetail save(OrderDetail orderDetail);

	public List<OrderDetail> listAll();

	public OrderDetail getById(Long orderDetailId);

	public boolean remove(OrderDetail orderDetail);

	public boolean shipOrderDetail(ShippingOrder orderDetail, String trackingNumber);
}
