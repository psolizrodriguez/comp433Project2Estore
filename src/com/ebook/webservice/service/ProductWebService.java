package com.ebook.webservice.service;

import java.util.List;

import javax.jws.WebService;

import com.ebook.webservice.representation.ProductRepresentation;

@WebService
public interface ProductWebService {

	public List<ProductRepresentation> getProducts(String keywords);

}
