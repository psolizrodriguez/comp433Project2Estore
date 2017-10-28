package com.ebook.dao.item;

import java.util.List;

import com.ebook.common.dao.Dao;
import com.ebook.model.item.Product;

public interface ProductDao extends Dao {
	public Product save(Product product);

	public List<Product> listAll();

	public Product getById(Long productId);

	public boolean remove(Product product);
}
