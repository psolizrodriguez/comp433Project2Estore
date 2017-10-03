package com.ebook.dao.order.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ebook.common.dao.AbstractBaseDao;
import com.ebook.dao.order.RefundDao;
import com.ebook.model.order.Refund;

@SuppressWarnings("rawtypes")
@Repository
public class RefundDaoImpl extends AbstractBaseDao implements RefundDao {

	@SuppressWarnings("unchecked")
	@Transactional
	public Refund save(Refund refund) {
		return (Refund) super.store(refund);
	}

	public List<Refund> listAll() {
		return super.verifyListNamedQueryAll("com.ebook.dao.refund.impl.RefundDaoImpl.listAll");
	}

	@Transactional
	public boolean remove(Refund refund) {
		return super.remove(refund);

	}

	@Override
	public Refund getById(String refundId) {
		return super.verifyNamedQueryAll("com.ebook.dao.refund.impl.RefundDaoImpl.getById", refundId);
	}
}