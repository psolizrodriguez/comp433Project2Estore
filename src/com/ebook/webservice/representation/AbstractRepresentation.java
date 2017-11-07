package com.ebook.webservice.representation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.ebook.common.utility.AppBaseUtilsWeb;

public abstract class AbstractRepresentation {

	@XmlElement(name = "link", namespace = "")
	protected List<Link> links;

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(Link... links) {
		this.links = Arrays.asList(links);
	}

	public void createLinks(String... params) {
		List<String[]> valuesLinks = new ArrayList<>();
		int counter = 0;
		if (this instanceof InventoryRepresentation) {
			valuesLinks.add(AppBaseUtilsWeb.getValuesOfPropertiesForLinks("orderService", "searchInventoryofProduct",
					counter++, params));
		}
		if (valuesLinks != null && valuesLinks.size() > 0) {
			this.links = new ArrayList<>();
			for (String[] strings : valuesLinks) {
				this.links.add(new Link(strings[0], strings[1], strings[2], strings[3]));
			}

		}
	}
}
