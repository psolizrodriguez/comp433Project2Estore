package com.ebook.webservice.workflow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.model.item.Inventory;
import com.ebook.service.item.InventoryService;
import com.ebook.webservice.representation.ProductRepresentation;

@Service
public class ProductActivityImpl implements ProductActivity {

	@Autowired
	private InventoryService inventoryService;

	public List<ProductRepresentation> getProfiles(String keywords) {

		List<Inventory> inventories = new ArrayList<>();
		List<ProductRepresentation> productRepresentations = new ArrayList<>();
		inventories = inventoryService.listAllInventoryByKeywords(keywords);

		Iterator<Inventory> it = inventories.iterator();
		while (it.hasNext()) {
			Inventory inventory = (Inventory) it.next();
			productRepresentations.add(new ProductRepresentation(inventory.getProduct().getProductId(),
					inventory.getInventoryId(), inventory.getProduct().getTitle(),
					inventory.getProduct().getDescription(), inventory.getPrice(), inventory.getQuantity()));
		}
		return productRepresentations;
	}
}
