package com.ebook.dao.item.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ebook.common.dao.AbstractBaseDao;
import com.ebook.dao.item.ProductDao;
import com.ebook.model.item.Product;

@SuppressWarnings("rawtypes")
@Repository
public class ProductDaoImpl extends AbstractBaseDao implements ProductDao {

	@SuppressWarnings("unchecked")
	@Transactional
	public Product save(Product product) {
		return (Product) super.store(product);
	}

	public List<Product> listAll() {
		return super.verifyListNamedQueryAll("com.ebook.dao.product.impl.ProductDaoImpl.listAll");
	}

	@Transactional
	public boolean remove(Product product) {
		return super.remove(product);

	}

	@Override
	public Product getById(String productId) {
		return super.verifyNamedQueryAll("com.ebook.dao.product.impl.ProductDaoImpl.getById", productId);
	}
}