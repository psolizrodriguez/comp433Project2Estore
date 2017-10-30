package com.ebook.service.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.common.constants.AppBaseConstantsWeb;
import com.ebook.common.utility.AppBaseUtilsWeb;
import com.ebook.dao.item.InventoryDao;
import com.ebook.dao.order.CustomerOrderDao;
import com.ebook.dao.order.OrderDetailDao;
import com.ebook.model.order.CustomerOrder;
import com.ebook.model.order.OrderDetail;
import com.ebook.model.order.PaymentMethod;
import com.ebook.model.order.PickUpOrder;
import com.ebook.model.order.Refund;
import com.ebook.service.order.CustomerOrderService;
import com.ebook.service.order.RefundService;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {
	@Autowired
	CustomerOrderDao dao;
	@Autowired
	RefundService refundService;
	@Autowired
	InventoryDao inventoryDao;
	@Autowired
	OrderDetailDao orderDetailDao;

	@Override
	public CustomerOrder save(CustomerOrder customerOrder) {
		return dao.save(customerOrder);
	}

	@Override
	public List<CustomerOrder> listAll() {
		return dao.listAll();
	}
	
	@Override
	public List<CustomerOrder> listAllOrdersByCustomerId(Long customerId) {
		return dao.listAllByCustomerId(customerId);
	}

	@Override
	public List<CustomerOrder> listAllOrdersByCustomerId_OrderStatus(Long customerId, String orderStatus) {
		return dao.listAllByCustomerId_OrderStatus(customerId, orderStatus);
	}

	@Override
	public CustomerOrder getById(Long customerOrderId) {
		return dao.getById(customerOrderId);
	}

	@Override
	public boolean remove(CustomerOrder customerOrder) {
		return dao.remove(customerOrder);
	}

	public boolean acceptPayment(CustomerOrder customerOrder) {
		if (customerOrder.getPaymentMethod() != null && customerOrder.getPaymentMethod().size() > 0) {
			for (PaymentMethod paymentMethod : customerOrder.getPaymentMethod()) {
				paymentMethod.setPaymentStatus(AppBaseConstantsWeb.PAYMENT_STATUS_VERIFIED);
			}
		}
		customerOrder.setPaymentStatus(AppBaseConstantsWeb.PAYMENT_STATUS_VERIFIED);
		customerOrder.setOrderState(AppBaseConstantsWeb.ORDER_STATUS_READY_TO_SHIP);
		customerOrder = save(customerOrder);
		return customerOrder != null;
	}

	@Override
	public boolean fulfillOrder(CustomerOrder customerOrder) {
		if (customerOrder.getOrderDetails() != null && customerOrder.getOrderDetails().size() > 0) {
			for (OrderDetail orderDetail : customerOrder.getOrderDetails()) {
				if (orderDetail.getInventory().getQuantity() < orderDetail.getQuantity()) {
					customerOrder.setOrderState(AppBaseConstantsWeb.ORDER_STATUS_CANCELED);
				} else {
					if (orderDetail instanceof PickUpOrder) {
						((PickUpOrder) orderDetail).setTimeForPickUp(
								AppBaseUtilsWeb.CalendarToString(AppBaseUtilsWeb.getCurrentTime(), "mm/dd/yyyy")
										+ " 09:00 - 17:00");
						((PickUpOrder) orderDetail).setOrderState(AppBaseConstantsWeb.ORDER_STATUS_READY_TO_PICK_UP);
						orderDetail.getInventory()
								.setQuantity(orderDetail.getInventory().getQuantity() - orderDetail.getQuantity());
						
					}
				}
			}
		}
		if (customerOrder.getOrderState().equals(AppBaseConstantsWeb.ORDER_STATUS_READY_TO_SHIP)) {
			customerOrder.setOrderState(AppBaseConstantsWeb.ORDER_STATUS_FULFILLED);
			if (customerOrder.getPaymentMethod() != null && customerOrder.getPaymentMethod().size() > 0) {
				for (PaymentMethod paymentMethod : customerOrder.getPaymentMethod()) {
					paymentMethod.setPaymentStatus(AppBaseConstantsWeb.PAYMENT_STATUS_PAID);
				}
			}
		}
		customerOrder = save(customerOrder);
		return customerOrder != null;
	}

	@Override
	public boolean cancelOrderDetail(CustomerOrder customerOrder, OrderDetail orderDetail) {
		orderDetail.setOrderState(AppBaseConstantsWeb.ORDER_STATUS_CANCELED);
		orderDetail.getInventory().setQuantity(orderDetail.getInventory().getQuantity() + orderDetail.getQuantity());
		Double ammountRefund = orderDetail.getSubTotal();
		customerOrder.setTotal(customerOrder.getTotal() - ammountRefund);
		if (customerOrder.getPaymentMethod() != null && customerOrder.getPaymentMethod().size() > 0) {
			for (PaymentMethod paymentMethod : customerOrder.getPaymentMethod()) {
				if (ammountRefund > 0.0) {
					Double refunded = 0.0;
					if (paymentMethod.getSubTotal() > ammountRefund) {
						refunded = ammountRefund;
						ammountRefund = 0.0;
					} else {
						ammountRefund -= paymentMethod.getSubTotal();
						refunded = paymentMethod.getSubTotal();
					}
					Refund refund = new Refund(null,
							AppBaseConstantsWeb.PAYMENT_STATUS_PENDING, refunded, orderDetail, paymentMethod);
					refund = refundService.save(refund);
					if (paymentMethod.getSubTotal() == refunded) {
						paymentMethod.setPaymentStatus(AppBaseConstantsWeb.PAYMENT_STATUS_REFUNDED);
					} else {
						paymentMethod.setPaymentStatus(AppBaseConstantsWeb.PAYMENT_STATUS_PARTIALLY_REFUNDED);
					}
				}

			}
		}
		customerOrder = save(customerOrder);
		return customerOrder != null;
	}

}
