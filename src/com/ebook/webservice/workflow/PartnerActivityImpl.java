package com.ebook.webservice.workflow;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.common.utility.AppBaseUtilsWeb;
import com.ebook.model.item.Partner;
import com.ebook.service.item.PartnerService;
import com.ebook.webservice.representation.PartnerRepresentation;
import com.ebook.webservice.representation.PartnerRequest;

@Service
public class PartnerActivityImpl implements PartnerActivity {

	@Autowired
	private PartnerService partnerService;

	@Override
	public PartnerRepresentation createPartner(PartnerRequest partnerRequest) {
		return new PartnerRepresentation(
				partnerService.save(new Partner(null, partnerRequest.getName(), partnerRequest.getUserName(),
						AppBaseUtilsWeb.encriptText(partnerRequest.getPassword()), new ArrayList<>())));
	}

}
