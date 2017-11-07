package com.ebook.webservice.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ebook.model.customer.Customer;

@XmlRootElement(name = "Customer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class CustomerRepresentation extends AbstractRepresentation {
	private Long customerId;
	private String lastName;
	private String firstName;
	private String userName;
	private String password;
	private AddressRepresentation billingAddress;
	private AddressRepresentation shippingAddress;

	public CustomerRepresentation(Long customerId, String lastName, String firstName, String userName, String password,
			AddressRepresentation billingAddress, AddressRepresentation shippingAddress) {
		this.customerId = customerId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.userName = userName;
		this.password = password;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
	}
	
	public CustomerRepresentation(Customer customer) {
		this.customerId = customer.getCustomerId();
		this.lastName = customer.getLastName();
		this.firstName = customer.getFirstName();
		this.userName = customer.getUserName();
		this.password = customer.getPassword();
		this.billingAddress = new AddressRepresentation(customer.getBillingAddress());
		this.shippingAddress = new AddressRepresentation(customer.getShippingAddress());
	}

	public CustomerRepresentation() {
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

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

	public AddressRepresentation getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(AddressRepresentation billingAddress) {
		this.billingAddress = billingAddress;
	}

	public AddressRepresentation getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(AddressRepresentation shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

}
