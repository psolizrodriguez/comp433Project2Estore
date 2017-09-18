package com.ebook.model.order;

import com.ebook.model.customer.Address;

public class ShippingOrder extends Order {
	private Address shippingAddress;

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

}
