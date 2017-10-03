package com.ebook.model.order;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.ebook.model.customer.Address;
import com.ebook.model.customer.Customer;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class CustomerOrder {
	@Id
	private String orderId;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn
	private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
	private String paymentStatus;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private Customer customer;
	private String orderState = "Open";
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private Address billingAddress;
	private Double total;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn
	private List<PaymentMethod> paymentMethod = new ArrayList<PaymentMethod>();

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
		if (orderDetails.size() > 0) {
			this.total = 0.0;
			for (OrderDetail orderDetail : orderDetails) {
				this.total += orderDetail.getSubTotal();
			}
		}
		this.orderDetails = orderDetails;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<PaymentMethod> getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(List<PaymentMethod> paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}
