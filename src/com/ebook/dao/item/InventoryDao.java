package com.ebook.dao.item;

import java.util.List;

import com.ebook.common.dao.Dao;
import com.ebook.model.item.Inventory;

public interface InventoryDao extends Dao {
	public Inventory save(Inventory inventory);

	public List<Inventory> listAll();

	public Inventory getById(Long inventoryId);

	public boolean remove(Inventory inventory);

	public List<Inventory> listAllInventoryByKeywords(String keywords);
}
