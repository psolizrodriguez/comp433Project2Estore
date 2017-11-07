package com.ebook.webservice.representation;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ebook.model.order.CreditCardPayment;
import com.ebook.model.order.CustomerOrder;
import com.ebook.model.order.OrderDetail;
import com.ebook.model.order.PayPalPayment;
import com.ebook.model.order.PaymentMethod;

@XmlRootElement(name = "CustomerOrder")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class CustomerOrderRepresentation extends AbstractRepresentation {
	private Long orderId;
	private List<OrderDetailRepresentation> orderDetails;
	private String paymentStatus;
	private CustomerRepresentation customer;
	private String orderState;
	private AddressRepresentation billingAddress;
	private Double total;
	private List<PaymentMethodRepresentation> paymentMethod;
	
	
	public CustomerOrderRepresentation() {
	}
	public CustomerOrderRepresentation(Long orderId, List<OrderDetailRepresentation> orderDetails, String paymentStatus,
			CustomerRepresentation customer, String orderState, AddressRepresentation billingAddress, Double total,
			List<PaymentMethodRepresentation> paymentMethod) {
		this.orderId = orderId;
		this.orderDetails = orderDetails;
		this.paymentStatus = paymentStatus;
		this.customer = customer;
		this.orderState = orderState;
		this.billingAddress = billingAddress;
		this.total = total;
		this.paymentMethod = paymentMethod;
	}
	
	public CustomerOrderRepresentation(CustomerOrder customerOrder) {
		this.orderId = customerOrder.getOrderId();
		this.orderDetails =  new ArrayList<>();
		if(customerOrder.getOrderDetails() != null && customerOrder.getOrderDetails().size() > 0) {
			for (OrderDetail auxOrderDetail : customerOrder.getOrderDetails()) {
				orderDetails.add(new OrderDetailRepresentation(auxOrderDetail));
			}
		}
		this.paymentStatus = customerOrder.getPaymentStatus();
		this.customer = new CustomerRepresentation(customerOrder.getCustomer());
		this.orderState = customerOrder.getOrderState();
		this.billingAddress = new AddressRepresentation(customerOrder.getBillingAddress());
		this.total = customerOrder.getTotal();
		this.paymentMethod=  new ArrayList<>();
		if(customerOrder.getPaymentMethod() != null && customerOrder.getPaymentMethod().size() > 0) {
			for (PaymentMethod auxPaymentMethod: customerOrder.getPaymentMethod()) {
				if (auxPaymentMethod instanceof PayPalPayment) {
				paymentMethod.add(new PayPalPaymentRepresentation((PayPalPayment) auxPaymentMethod));
				}else {
					if (auxPaymentMethod instanceof CreditCardPayment) {
						paymentMethod.add(new CreditCardPaymentRepresentation((CreditCardPayment) auxPaymentMethod));
						}else {
							paymentMethod.add(new PaymentMethodRepresentation(auxPaymentMethod));
						}
				}
			}
		}
	}
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public List<OrderDetailRepresentation> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetailRepresentation> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public CustomerRepresentation getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerRepresentation customer) {
		this.customer = customer;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public AddressRepresentation getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(AddressRepresentation billingAddress) {
		this.billingAddress = billingAddress;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public List<PaymentMethodRepresentation> getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(List<PaymentMethodRepresentation> paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	
}
