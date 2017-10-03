package com.ebook.model.order;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.ebook.model.item.Inventory;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class OrderDetail {
	@Id
	private String orderDetailId;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private Inventory inventory;
	private Integer quantity;
	private Double subTotal;
	private String orderState;

	public OrderDetail() {

	}

	public OrderDetail(String orderDetailId, Inventory inventory, Integer quantity, String orderState) {
		this.orderDetailId = orderDetailId;
		this.inventory = inventory;
		this.quantity = quantity;
		this.subTotal = inventory.getPrice() * this.quantity;
		this.orderState = orderState;
	}

	public String getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
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
