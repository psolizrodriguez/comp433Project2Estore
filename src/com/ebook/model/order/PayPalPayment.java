package com.ebook.model.order;

import javax.persistence.Entity;

@Entity
public class PayPalPayment extends PaymentMethod {
	String transactionId;
	String accountEmail;

	public PayPalPayment() {

	}

	public PayPalPayment(String paymentId, String paymentStatus, Double subTotal, String transactionId,
			String accountEmail) {
		super(paymentId, paymentStatus, subTotal);
		this.transactionId = transactionId;
		this.accountEmail = accountEmail;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getAccountEmail() {
		return accountEmail;
	}

	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}

}
