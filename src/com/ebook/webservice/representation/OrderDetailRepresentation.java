package com.ebook.webservice.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ebook.model.order.OrderDetail;

@XmlRootElement(name = "OrderDetail")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderDetailRepresentation {
	private Long orderDetailId;
	private InventoryRepresentation inventory;
	private Integer quantity;
	private Double subTotal;
	private String orderState;

	public OrderDetailRepresentation() {

	}

	public OrderDetailRepresentation(OrderDetail orderDetail) {
		this.orderDetailId = orderDetail.getOrderDetailId();
		this.inventory = new InventoryRepresentation(orderDetail.getInventory());
		this.quantity = orderDetail.getQuantity();
		this.subTotal = orderDetail.getSubTotal();
		this.orderState = orderDetail.getOrderState();
	}

	public Long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public InventoryRepresentation getInventory() {
		return inventory;
	}

	public void setInventory(InventoryRepresentation inventory) {
		this.inventory = inventory;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

}
