package com.ebook.service.item.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.dao.item.ProductDao;
import com.ebook.model.item.Product;
import com.ebook.service.item.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao dao;

	@Override
	public Product save(Product product) {
		return dao.save(product);
	}

	@Override
	public List<Product> listAll() {
		return dao.listAll();
	}

	@Override
	public Product getById(String productId) {
		return dao.getById(productId);
	}

	@Override
	public boolean remove(Product product) {
		return dao.remove(product);
	}

}
