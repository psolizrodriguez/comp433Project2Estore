package com.ebook.model.order;

import javax.persistence.Entity;

@Entity
public class PayPalPayment extends PaymentMethod {
	String transactionId;
	String accountEmail;
}
