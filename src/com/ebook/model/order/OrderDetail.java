package com.ebook.model.order;

import com.ebook.model.item.Inventory;

public class OrderDetail {
	private Inventory inventory;
	private int quantity;
	private double subTotal;

	public OrderDetail() {
	}

	public OrderDetail(Inventory inventory, int quantity) {
		this.inventory = inventory;
		this.quantity = quantity;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
