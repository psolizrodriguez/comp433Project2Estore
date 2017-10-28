package com.ebook.dao.item.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ebook.common.dao.AbstractBaseDao;
import com.ebook.dao.item.PartnerDao;
import com.ebook.model.item.Partner;

@SuppressWarnings("rawtypes")
@Repository
public class PartnerDaoImpl extends AbstractBaseDao implements PartnerDao {

	@SuppressWarnings("unchecked")
	@Transactional
	public Partner save(Partner partner) {
		return (Partner) super.store(partner);
	}

	public List<Partner> listAll() {
		return super.verifyListNamedQueryAll("com.ebook.dao.partner.impl.PartnerDaoImpl.listAll");
	}

	@Transactional
	public boolean remove(Partner partner) {
		return super.remove(partner);

	}

	@Override
	public Partner getById(Long partnerId) {
		return super.verifyNamedQueryAll("com.ebook.dao.partner.impl.PartnerDaoImpl.getById", partnerId);
	}
}