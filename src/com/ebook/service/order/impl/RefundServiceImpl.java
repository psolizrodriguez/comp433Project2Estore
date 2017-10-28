package com.ebook.service.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.dao.order.RefundDao;
import com.ebook.model.order.Refund;
import com.ebook.service.order.RefundService;

@Service
public class RefundServiceImpl implements RefundService {
	@Autowired
	RefundDao dao;

	@Override
	public Refund save(Refund refund) {
		return dao.save(refund);
	}

	@Override
	public List<Refund> listAll() {
		return dao.listAll();
	}

	@Override
	public Refund getById(Long refundId) {
		return dao.getById(refundId);
	}

	@Override
	public boolean remove(Refund refund) {
		return dao.remove(refund);
	}

}
