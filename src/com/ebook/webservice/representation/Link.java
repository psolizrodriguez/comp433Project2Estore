package com.ebook.webservice.representation;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Link")
public class Link {
	private String type;
	private String method;
	private String rel;
	private String href;

	public Link() {
	}

	public Link(String type, String method, String rel, String href) {
		this.type = type;
		this.method = method;
		this.rel = rel;
		this.href = href;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

}
