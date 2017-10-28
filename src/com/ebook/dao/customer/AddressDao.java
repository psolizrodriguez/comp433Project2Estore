package com.ebook.dao.customer;

import java.util.List;

import com.ebook.common.dao.Dao;
import com.ebook.model.customer.Address;

public interface AddressDao extends Dao {
	public Address save(Address address);

	public List<Address> listAll();

	public Address getById(Long addressId);

	public boolean remove(Address address);
}
