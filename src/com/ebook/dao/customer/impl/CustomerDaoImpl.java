package com.ebook.dao.customer.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ebook.common.dao.AbstractBaseDao;
import com.ebook.dao.customer.CustomerDao;
import com.ebook.model.customer.Customer;

@SuppressWarnings("rawtypes")
@Repository
public class CustomerDaoImpl extends AbstractBaseDao implements CustomerDao {

	@SuppressWarnings("unchecked")
	@Transactional
	public Customer save(Customer customer) {
		return (Customer) super.store(customer);
	}

	public List<Customer> listAll() {
		return super.verifyListNamedQueryAll("com.ebook.dao.customer.impl.CustomerDaoImpl.listAll");
	}

	@Transactional
	public boolean remove(Customer customer) {
		return super.remove(customer);

	}

	@Override
	public Customer getById(String customerId) {
		return super.verifyNamedQueryAll("com.ebook.dao.customer.impl.CustomerDaoImpl.getById", customerId);
	}
}