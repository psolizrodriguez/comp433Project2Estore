package com.ebook.webservice.service;

import javax.jws.WebService;

import com.ebook.webservice.representation.CustomerOrderRepresentation;
import com.ebook.webservice.representation.CustomerOrderRequest;
import com.ebook.webservice.representation.PartnerRepresentation;
import com.ebook.webservice.representation.PartnerRequest;

@WebService
public interface PartnerWebService {

	public PartnerRepresentation createPartner(PartnerRequest partnerRequest);
	
	public CustomerOrderRepresentation acceptPayment(CustomerOrderRequest customerOrderRequest);
	
	public CustomerOrderRepresentation fulfillOrder(CustomerOrderRequest customerOrderRequest);

}
