package com.ebook.webservice.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ebook.model.order.PaymentMethod;

@XmlRootElement(name = "PaymentMethod")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class PaymentMethodRepresentation {
	private Long paymentId;
	private String paymentStatus;
	private Double subTotal;

	public PaymentMethodRepresentation() {

	}

	public PaymentMethodRepresentation(Long paymentId, String paymentStatus, double subTotal) {
		this.paymentId = paymentId;
		this.paymentStatus = paymentStatus;
		this.subTotal = subTotal;
	}
	
	public PaymentMethodRepresentation(PaymentMethod paymentMethod) {
		this.paymentId = paymentMethod.getPaymentId();
		this.paymentStatus = paymentMethod.getPaymentStatus();
		this.subTotal = paymentMethod.getSubTotal();
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
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
