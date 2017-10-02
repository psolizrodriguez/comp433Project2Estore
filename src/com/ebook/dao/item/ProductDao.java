package com.ebook.dao.item;

import java.util.List;

import com.ebook.common.dao.Dao;
import com.ebook.model.item.Product;

public interface ProductDao extends Dao {
	public Product add(Product product);

	public List<Product> listAll();

	public Product getById(String productId);

	public boolean remove(Product product);
}
