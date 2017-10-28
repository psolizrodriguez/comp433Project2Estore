package com.ebook.service.item;

import java.util.List;

import com.ebook.model.item.Product;

public interface ProductService {
	public Product save(Product product);

	public List<Product> listAll();

	public Product getById(Long productId);

	public boolean remove(Product product);
}
