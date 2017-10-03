package com.ebook.service.item;

import java.util.List;

import com.ebook.model.item.Inventory;

public interface InventoryService {
	public Inventory save(Inventory inventory);

	public List<Inventory> listAll();

	public Inventory getById(String inventoryId);

	public boolean remove(Inventory inventory);

	public List<Inventory> listAllInventoryByKeywords(String keywords);
}
