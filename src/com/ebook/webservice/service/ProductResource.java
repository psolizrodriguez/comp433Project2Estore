package com.ebook.webservice.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebook.webservice.representation.ProductRepresentation;
import com.ebook.webservice.workflow.ProductActivity;

@Component
@Path("/productservice/")
public class ProductResource implements ProductWebService {

	@Autowired
	ProductActivity productActivity;

	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/product")
	public List<ProductRepresentation> getProducts(@QueryParam("keywords") String keywords) {
		System.out.println("GET METHOD Request for all products .............");
		return productActivity.getProducts(keywords);
	}

}