package com.ebook.model.order;

import javax.persistence.Entity;

import com.ebook.model.item.Inventory;

@Entity
public class PickUpOrder extends OrderDetail {

	private String timeForPickUp;

	public PickUpOrder() {

	}

	public PickUpOrder(Long orderDetailId, Inventory inventory, Integer quantity, String orderState) {
		super(orderDetailId, inventory, quantity, orderState);
	}

	public String getTimeForPickUp() {
		return timeForPickUp;
	}

	public void setTimeForPickUp(String timeForPickUp) {
		this.timeForPickUp = timeForPickUp;
	}

}
