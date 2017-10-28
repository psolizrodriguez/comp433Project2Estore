package com.ebook.webservice.workflow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.model.item.Inventory;
import com.ebook.service.item.InventoryService;
import com.ebook.webservice.representation.InventoryRepresentation;

@Service
public class OrderActivityImpl implements OrderActivity {

	@Autowired
	private InventoryService inventoryService;

	public List<InventoryRepresentation> getProducts(String keywords) {

		List<Inventory> listInventory = new ArrayList<>();
		List<InventoryRepresentation> inventoryRepresentation = new ArrayList<>();
		if (keywords == null) {
			listInventory = inventoryService.listAll();
		} else {
			listInventory = inventoryService.listAllInventoryByKeywords(keywords);
		}

		Iterator<Inventory> it = listInventory.iterator();
		while (it.hasNext()) {
			Inventory inventory = (Inventory) it.next();
			inventoryRepresentation.add(new InventoryRepresentation(inventory));
		}
		return inventoryRepresentation;
	}
}
