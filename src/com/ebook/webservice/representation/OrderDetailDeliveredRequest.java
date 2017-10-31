package com.ebook.webservice.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderDetailDeliveredRequest {
	private Long orderDetailId;
	private String deliveredTime;

	public OrderDetailDeliveredRequest() {
	}

	public OrderDetailDeliveredRequest(Long orderDetailId, String deliveredTime) {
		this.orderDetailId = orderDetailId;
		this.deliveredTime = deliveredTime;
	}

	public Long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public String getDeliveredTime() {
		return deliveredTime;
	}

	public void setDeliveredTime(String deliveredTime) {
		this.deliveredTime = deliveredTime;
	}

}
