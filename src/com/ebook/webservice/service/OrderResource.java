package com.ebook.webservice.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebook.webservice.representation.InventoryRepresentation;
import com.ebook.webservice.workflow.OrderActivity;

@Component
@Path("/orderService/")
public class OrderResource implements OrderWebService {

	@Autowired
	OrderActivity orderActivity;

	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/searchInventoryofProduct")
	public List<InventoryRepresentation> getProducts(@QueryParam("keywords") String keywords) {
		System.out.println("GET METHOD Request for all products .............");
		return orderActivity.getProducts(keywords);
	}

}