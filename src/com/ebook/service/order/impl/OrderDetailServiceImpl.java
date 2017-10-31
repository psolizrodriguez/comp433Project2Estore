package com.ebook.service.order.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.common.constants.AppBaseConstantsWeb;
import com.ebook.common.utility.AppBaseUtilsWeb;
import com.ebook.dao.item.InventoryDao;
import com.ebook.dao.order.OrderDetailDao;
import com.ebook.model.order.OrderDetail;
import com.ebook.model.order.ShippingOrder;
import com.ebook.service.order.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
	OrderDetailDao dao;
	@Autowired
	InventoryDao inventoryDao;

	@Override
	public OrderDetail save(OrderDetail orderDetail) {
		return dao.save(orderDetail);
	}

	@Override
	public List<OrderDetail> listAll() {
		return dao.listAll();
	}

	@Override
	public OrderDetail getById(Long orderDetailId) {
		return dao.getById(orderDetailId);
	}

	@Override
	public boolean remove(OrderDetail orderDetail) {
		return dao.remove(orderDetail);
	}

	@Override
	public boolean shipOrderDetail(ShippingOrder orderDetail, String trackingNumber) {
		if (orderDetail.getOrderState().equals(AppBaseConstantsWeb.ORDER_STATUS_READY_TO_SHIP)) {
			orderDetail.getInventory()
					.setQuantity(orderDetail.getInventory().getQuantity() - orderDetail.getQuantity());
			// inventoryDao.save(orderDetail.getInventory());
			orderDetail.setOrderState(AppBaseConstantsWeb.ORDER_STATUS_SHIPPED);
			orderDetail.setTrackingNumber(trackingNumber);
			Calendar deliveryDate = AppBaseUtilsWeb.getCurrentTime();
			deliveryDate.add(Calendar.DATE, 3);
			orderDetail.setEstimatedDelivery(deliveryDate);
			orderDetail = (ShippingOrder) save(orderDetail);
			return orderDetail != null;
		}
		return false;
	}

	@Override
	public List<OrderDetail> listAllByPartnerId(Long partnerId) {
		return dao.listAllByPartnerId(partnerId);
	}

	@Override
	public List<OrderDetail> listAllByPartnerId_OrderState(Long partnerId, String orderState) {
		return dao.listAllByPartnerId_OrderState(partnerId, orderState);
	}

	@Override
	public boolean orderDelivered(ShippingOrder orderDetail, Calendar delivered) {
		if (orderDetail.getOrderState().equals(AppBaseConstantsWeb.ORDER_STATUS_SHIPPED)) {
			orderDetail.setOrderState(AppBaseConstantsWeb.ORDER_STATUS_DELIVERED);
			orderDetail.setDelivered(delivered);
			orderDetail = (ShippingOrder) save(orderDetail);
			return orderDetail != null;
		}
		return false;
	}

}
