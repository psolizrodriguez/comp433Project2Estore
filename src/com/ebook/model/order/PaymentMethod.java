package com.ebook.model.order;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class PaymentMethod {
	@Id
	private String paymentId;
	private String paymentStatus;
	private Double subTotal;

	public PaymentMethod() {

	}

	public PaymentMethod(String paymentId, String paymentStatus, double subTotal) {
		this.paymentId = paymentId;
		this.paymentStatus = paymentStatus;
		this.subTotal = subTotal;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

}
