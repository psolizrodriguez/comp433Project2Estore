package com.ebook.webservice.service;

import javax.jws.WebService;

import com.ebook.webservice.representation.PartnerRepresentation;
import com.ebook.webservice.representation.PartnerRequest;

@WebService
public interface PartnerWebService {

	public PartnerRepresentation createPartner(PartnerRequest partnerRequest);

}
