package com.ebook.service.item.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.dao.item.PartnerDao;
import com.ebook.model.item.Partner;
import com.ebook.service.item.PartnerService;

@Service
public class PartnerServiceImpl implements PartnerService {
	@Autowired
	PartnerDao dao;

	@Override
	public Partner add(Partner partner) {
		return dao.add(partner);
	}

	@Override
	public List<Partner> listAll() {
		return dao.listAll();
	}

	@Override
	public Partner getById(String partnerId) {
		return dao.getById(partnerId);
	}

	@Override
	public boolean remove(Partner partner) {
		return dao.remove(partner);
	}

}
