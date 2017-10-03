package com.ebook.model.order;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.ebook.model.customer.Address;

@Entity
public class ShippingOrder extends CustomerOrder {
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private Address shippingAddress;
	private Calendar estimatedDelivery;

	public Calendar getEstimatedDelivery() {
		return estimatedDelivery;
	}

	public void setEstimatedDelivery(Calendar estimatedDelivery) {
		this.estimatedDelivery = estimatedDelivery;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

}
