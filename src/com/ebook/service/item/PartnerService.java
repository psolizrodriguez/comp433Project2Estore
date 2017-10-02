package com.ebook.service.item;

import java.util.List;

import com.ebook.model.item.Partner;

public interface PartnerService {
	public Partner add(Partner partner);

	public List<Partner> listAll();

	public Partner getById(String partnerId);

	public boolean remove(Partner menu);
}
