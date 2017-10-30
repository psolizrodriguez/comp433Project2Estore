package com.ebook.webservice.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ebook.model.item.Partner;

@XmlRootElement(name = "Partner")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class PartnerRepresentation {
	private Long partnerId;
	private String name;
	private String userName;

	public PartnerRepresentation() {
	}

	public PartnerRepresentation(Long partnerId, String name, String userName) {
		this.partnerId = partnerId;
		this.name = name;
		this.userName = userName;
	}

	public PartnerRepresentation(Partner partner) {
		this.partnerId = partner.getPartnerId();
		this.name = partner.getName();
		this.userName = partner.getUserName();

	}

	public Long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
