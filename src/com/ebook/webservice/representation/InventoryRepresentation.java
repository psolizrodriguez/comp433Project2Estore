package com.ebook.webservice.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ebook.model.item.Inventory;

@XmlRootElement(name = "Inventory")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class InventoryRepresentation {
	private Long inventoryId;
	private ProductRepresentation productRepresentation;
	private Double price;
	private Integer quantity;

	public InventoryRepresentation() {
	}

	public InventoryRepresentation(Long inventoryId, ProductRepresentation productRepresentation, Double price,
			Integer quantity) {
		this.inventoryId = inventoryId;
		this.productRepresentation = productRepresentation;
		this.price = price;
		this.quantity = quantity;
	}

	public InventoryRepresentation(Inventory inventory) {
		this.inventoryId = inventory.getInventoryId();
		this.productRepresentation = new ProductRepresentation(inventory.getProduct());
		this.price = inventory.getPrice();
		this.quantity = inventory.getQuantity();
	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public ProductRepresentation getProductRepresentation() {
		return productRepresentation;
	}

	public void setProductRepresentation(ProductRepresentation productRepresentation) {
		this.productRepresentation = productRepresentation;
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
