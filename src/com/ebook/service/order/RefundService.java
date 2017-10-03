package com.ebook.service.order;

import java.util.List;

import com.ebook.model.order.Refund;

public interface RefundService {
	public Refund save(Refund refund);

	public List<Refund> listAll();

	public Refund getById(String refundId);

	public boolean remove(Refund refund);
}
