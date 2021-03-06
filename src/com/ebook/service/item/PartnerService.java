package com.ebook.service.item;

import java.util.List;

import com.ebook.model.item.Partner;

public interface PartnerService {
	public Partner save(Partner partner);

	public List<Partner> listAll();

	public Partner getById(Long partnerId);

	public boolean remove(Partner partner);
}
