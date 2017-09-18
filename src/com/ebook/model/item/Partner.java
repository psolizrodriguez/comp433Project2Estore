package com.ebook.model.item;

import java.util.ArrayList;
import java.util.List;

import com.ebook.model.customer.Address;

public class Partner {
	private String partnerId;
	private String name;
	private String userName;
	private String password;
	private Address billingAddress;
	private Address shippingAddress;
	private List<Inventory> orders = new ArrayList<Inventory>();

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public List<Inventory> getOrders() {
		return orders;
	}

	public void setOrders(List<Inventory> orders) {
		this.orders = orders;
	}

}
