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
	private PartnerRepresentation partner;
	private ProductRepresentation product;
	private Double price;
	private Integer quantity;

	public InventoryRepresentation() {
	}

	public InventoryRepresentation(Long inventoryId, PartnerRepresentation partner, ProductRepresentation product,
			Double price, Integer quantity) {
		this.inventoryId = inventoryId;
		this.partner = partner;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}

	public InventoryRepresentation(Inventory inventory) {
		this.inventoryId = inventory.getInventoryId();
		this.partner = new PartnerRepresentation(inventory.getPartner());
		this.product = new ProductRepresentation(inventory.getProduct());
		this.price = inventory.getPrice();
		this.quantity = inventory.getQuantity();
	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public PartnerRepresentation getPartner() {
		return partner;
	}

	public void setPartner(PartnerRepresentation partner) {
		this.partner = partner;
	}

	public ProductRepresentation getProduct() {
		return product;
	}

	public void setProduct(ProductRepresentation product) {
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
