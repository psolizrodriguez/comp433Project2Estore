package com.ebook.dao.customer.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ebook.common.dao.AbstractBaseDao;
import com.ebook.dao.customer.AddressDao;
import com.ebook.model.customer.Address;

@SuppressWarnings("rawtypes")
@Repository
public class AddressDaoImpl extends AbstractBaseDao implements AddressDao {

	@SuppressWarnings("unchecked")
	@Transactional
	public Address save(Address address) {
		return (Address) super.store(address);
	}

	public List<Address> listAll() {
		return super.verifyListNamedQueryAll("com.ebook.dao.address.impl.AddressDaoImpl.listAll");
	}

	@Transactional
	public boolean remove(Address address) {
		return super.remove(address);

	}

	@Override
	public Address getById(String addressId) {
		return super.verifyNamedQueryAll("com.ebook.dao.address.impl.AddressDaoImpl.getById", addressId);
	}
}