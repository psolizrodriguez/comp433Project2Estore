package com.ebook.webservice.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ebook.model.order.CreditCardPayment;

@XmlRootElement(name = "CreditCardPayment")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class CreditCardPaymentRepresentation extends PaymentMethodRepresentation {
	private String creditCardNumber;
	private String nameOnCard;
	private String securityCode;
	private String validDate;

	public CreditCardPaymentRepresentation() {

	}

	public CreditCardPaymentRepresentation(Long paymentId, String paymentStatus, Double subTotal, String creditCardNumber,
			String nameOnCard, String securityCode, String validDate) {
		super(paymentId, paymentStatus, subTotal);
		this.creditCardNumber = creditCardNumber;
		this.nameOnCard = nameOnCard;
		this.securityCode = securityCode;
		this.validDate = validDate;
	}
	
	public CreditCardPaymentRepresentation(CreditCardPayment creditCardPayment) {
		super(creditCardPayment);
		this.creditCardNumber = creditCardPayment.getCreditCardNumber();
		this.nameOnCard = creditCardPayment.getNameOnCard();
		this.securityCode = creditCardPayment.getSecurityCode();
		this.validDate = creditCardPayment.getValidDate();
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

}
