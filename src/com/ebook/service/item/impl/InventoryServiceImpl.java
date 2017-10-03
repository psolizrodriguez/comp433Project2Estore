package com.ebook.service.item.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.dao.item.InventoryDao;
import com.ebook.model.item.Inventory;
import com.ebook.service.item.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	InventoryDao dao;

	@Override
	public Inventory save(Inventory inventory) {
		return dao.save(inventory);
	}

	@Override
	public List<Inventory> listAll() {
		return dao.listAll();
	}

	@Override
	public Inventory getById(String inventoryId) {
		return dao.getById(inventoryId);
	}

	@Override
	public boolean remove(Inventory inventory) {
		return dao.remove(inventory);
	}

	@Override
	public List<Inventory> listAllInventoryByKeywords(String keywords) {
		return dao.listAllInventoryByKeywords(keywords);
	}

}
