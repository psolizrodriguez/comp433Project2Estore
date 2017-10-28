package com.ebook.webservice.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebook.webservice.representation.PartnerRepresentation;
import com.ebook.webservice.representation.PartnerRequest;
import com.ebook.webservice.workflow.PartnerActivity;

@Component
@Path("/partnerService/")
public class PartnerResource implements PartnerWebService {

	@Autowired
	PartnerActivity partnerActivity;

	@POST
	@Produces({ "application/xml", "application/json" })
	@Path("/createPartnerProfile")
	public PartnerRepresentation createPartner(PartnerRequest partnerRequest) {
		System.out.println("POST METHOD Message");
		return partnerActivity.createPartner(partnerRequest);
	}

}