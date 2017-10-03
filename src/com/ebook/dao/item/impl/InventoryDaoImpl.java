package com.ebook.dao.item.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ebook.common.dao.AbstractBaseDao;
import com.ebook.dao.item.InventoryDao;
import com.ebook.model.item.Inventory;

@SuppressWarnings("rawtypes")
@Repository
public class InventoryDaoImpl extends AbstractBaseDao implements InventoryDao {

	@SuppressWarnings("unchecked")
	@Transactional
	public Inventory save(Inventory inventory) {
		return (Inventory) super.store(inventory);
	}

	public List<Inventory> listAll() {
		return super.verifyListNamedQueryAll("com.ebook.dao.inventory.impl.InventoryDaoImpl.listAll");
	}

	@Transactional
	public boolean remove(Inventory inventory) {
		return super.remove(inventory);
	}

	@Override
	public Inventory getById(String inventoryId) {
		return super.verifyNamedQueryAll("com.ebook.dao.inventory.impl.InventoryDaoImpl.getById", inventoryId);
	}

	@Transactional
	public List<Inventory> listAllInventoryByKeywords(String keywords) {

		return super.verifyListNamedQueryAll("com.ebook.dao.inventory.impl.InventoryDaoImpl.listAllInventoryByKeywords",
				"%" + keywords.trim().replace(" ", "%") + "%");
	}
}