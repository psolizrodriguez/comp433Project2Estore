package com.ebook.webservice.workflow;

import com.ebook.webservice.representation.CustomerOrderRepresentation;
import com.ebook.webservice.representation.CustomerOrderRequest;
import com.ebook.webservice.representation.OrderDetailRepresentation;
import com.ebook.webservice.representation.OrderDetailRequest;
import com.ebook.webservice.representation.PartnerRepresentation;
import com.ebook.webservice.representation.PartnerRequest;

public interface PartnerActivity {

	public PartnerRepresentation createPartner(PartnerRequest partnerRequest);
	
	public CustomerOrderRepresentation acceptPayment(CustomerOrderRequest customerOrderRequest);
	
	public CustomerOrderRepresentation fulfillOrder(CustomerOrderRequest customerOrderRequest);
	
	public OrderDetailRepresentation shipOrder(OrderDetailRequest orderDetailRequest);
}
