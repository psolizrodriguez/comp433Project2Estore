package com.ebook.webservice.service;

import java.util.List;

import javax.jws.WebService;

import com.ebook.webservice.representation.InventoryRepresentation;

@WebService
public interface OrderWebService {

	public List<InventoryRepresentation> getProducts(String keywords);

}
