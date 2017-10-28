package com.ebook.service.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.dao.customer.AddressDao;
import com.ebook.model.customer.Address;
import com.ebook.service.order.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	AddressDao dao;

	@Override
	public Address save(Address address) {
		return dao.save(address);
	}

	@Override
	public List<Address> listAll() {
		return dao.listAll();
	}

	@Override
	public Address getById(Long addressId) {
		return dao.getById(addressId);
	}

	@Override
	public boolean remove(Address address) {
		return dao.remove(address);
	}

}
