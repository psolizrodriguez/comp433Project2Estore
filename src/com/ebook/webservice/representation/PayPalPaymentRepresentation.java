package com.ebook.webservice.representation;

import com.ebook.model.order.PayPalPayment;

public class PayPalPaymentRepresentation extends PaymentMethodRepresentation {
	String transactionId;
	String accountEmail;

	public PayPalPaymentRepresentation() {

	}

	public PayPalPaymentRepresentation(Long paymentId, String paymentStatus, Double subTotal, String transactionId,
			String accountEmail) {
		super(paymentId, paymentStatus, subTotal);
		this.transactionId = transactionId;
		this.accountEmail = accountEmail;
	}
	
	public PayPalPaymentRepresentation(PayPalPayment payPalPayment) {
		super(payPalPayment);
		this.transactionId = payPalPayment.getTransactionId();
		this.accountEmail = payPalPayment.getAccountEmail();
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
