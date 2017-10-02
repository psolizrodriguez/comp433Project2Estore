package com.ebook.service.item;

import java.util.List;

import com.ebook.model.item.Product;

public interface ProductService {
	public Product add(Product product);

	public List<Product> listAll();

	public Product getById(String productId);

	public boolean remove(Product menu);
}
