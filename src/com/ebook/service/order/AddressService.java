package com.ebook.service.order;

import java.util.List;

import com.ebook.model.customer.Address;

public interface AddressService {
	public Address save(Address address);

	public List<Address> listAll();

	public Address getById(Long addressId);

	public boolean remove(Address address);
}
