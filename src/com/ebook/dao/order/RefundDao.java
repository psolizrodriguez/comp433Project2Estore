package com.ebook.dao.order;

import java.util.List;

import com.ebook.common.dao.Dao;
import com.ebook.model.order.Refund;

public interface RefundDao extends Dao {
	public Refund save(Refund refund);

	public List<Refund> listAll();

	public Refund getById(Long refundId);

	public boolean remove(Refund refund);
}
