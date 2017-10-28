package com.ebook.webservice.workflow;

import java.util.List;

import com.ebook.webservice.representation.InventoryRepresentation;

public interface OrderActivity {

	public List<InventoryRepresentation> getProducts(String keywords);
}
