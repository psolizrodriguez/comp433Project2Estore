package com.ebook.webservice.workflow;

import java.util.List;

import com.ebook.webservice.representation.ProductRepresentation;

public interface ProductActivity {

	public List<ProductRepresentation> getProducts(String keywords);
}
