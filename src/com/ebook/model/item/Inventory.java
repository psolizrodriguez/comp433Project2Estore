package com.ebook.model.item;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Inventory {
	@Id
	private String inventoryId;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private Product product;
	private Double price;
	private Integer quantity;

	public Inventory() {

	}

	public Inventory(String inventoryId, Product product, Double price, Integer quantity) {
		this.inventoryId = inventoryId;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}

	public String getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
