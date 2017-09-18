package com.ebook.model.order;

import java.util.ArrayList;
import java.util.List;

import com.ebook.model.customer.Address;
import com.ebook.model.item.Inventory;

public class Order {
	private String orderId;
	private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
	private boolean paymentReceived;
	private String orderState = "Open";
	private Address billingAddress;
	private double total;
	private List<PaymentMethod> paymentMethod = new ArrayList<PaymentMethod>();

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<PaymentMethod> getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(List<PaymentMethod> paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Order() {
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getOrderState() {
		return orderState;
	}

	public boolean isPaymentReceived() {
		return paymentReceived;
	}

	public void setPaymentReceived(boolean paymentReceived) {
		this.paymentReceived = paymentReceived;
	}

	public void addProduct(Inventory inventory, int quantity) {
		if (orderState.equals("Open")) {
			orderDetails.add(new OrderDetail(inventory, quantity));
		} else {
			throw new IllegalStateException("Can only add product in Open state.");
		}
	}

	public void cancelOrder() {
		if (orderState.equals("Open") || orderState.equals("Ordered")) {
			orderState = "Canceled";
		} else {
			throw new IllegalStateException("Cannot cancel order in this state.");
		}
	}

	public void confirmOrder() {
		if (getOrderDetails().isEmpty()) {
			orderState = "Canceled";
		} else if (orderState.equals("Open")) {
			orderState = "Ordered";
		} else {
			throw new IllegalStateException("Cannot confirm order in this state.");
		}
	}

	public void orderDelivered() {
		if (orderState.equals("Shipped")) {
			orderState = "Delivered";
		} else {
			throw new IllegalStateException("Cannot be delivered from in this state.");
		}
	}

	public void orderPayed() {
		if (orderState.equals("Ordered")) {
			setPaymentReceived(true);
		} else {
			throw new IllegalStateException("Cannot pay in this state.");
		}
	}

	public void orderSendOut() {
		if (orderState.equals("Ordered") && paymentReceived) {
			orderState = "Shipped";
		} else {
			throw new IllegalStateException("Cannot send out in this state.");
		}
	}

	public boolean isFinished() {
		if (orderState.equals("Delivered") || orderState.equals("Canceled")) {
			return true;
		}
		return false;
	}

	public double getOrderTotal() {
		double total = 0.00;
		for (OrderDetail line : orderDetails) {
			total += line.getInventory().getPrice() * line.getQuantity();
		}
		return total;
	}

}
