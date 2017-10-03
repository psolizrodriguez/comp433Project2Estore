package com.ebook.dao.item;

import java.util.List;

import com.ebook.common.dao.Dao;
import com.ebook.model.item.Partner;

public interface PartnerDao extends Dao {
	public Partner save(Partner partner);

	public List<Partner> listAll();

	public Partner getById(String partnerId);

	public boolean remove(Partner partner);
}
