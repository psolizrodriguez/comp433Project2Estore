package com.ebook.webservice.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ebook.model.item.Product;

@XmlRootElement(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ProductRepresentation {
	private Long productId;
	private String title;
	private String description;

	public ProductRepresentation() {
	}

	public ProductRepresentation(Long productId, String title, String description) {
		this.productId = productId;
		this.title = title;
		this.description = description;
	}

	public ProductRepresentation(Product product) {
		this.productId = product.getProductId();
		this.title = product.getTitle();
		this.description = product.getDescription();
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
