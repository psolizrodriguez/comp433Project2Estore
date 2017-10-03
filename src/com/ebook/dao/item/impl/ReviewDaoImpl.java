package com.ebook.dao.item.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ebook.common.dao.AbstractBaseDao;
import com.ebook.dao.item.ReviewDao;
import com.ebook.model.item.Review;

@SuppressWarnings("rawtypes")
@Repository
public class ReviewDaoImpl extends AbstractBaseDao implements ReviewDao {

	@SuppressWarnings("unchecked")
	@Transactional
	public Review save(Review review) {
		return (Review) super.store(review);
	}

	public List<Review> listAll() {
		return super.verifyListNamedQueryAll("com.ebook.dao.review.impl.ReviewDaoImpl.listAll");
	}

	@Transactional
	public boolean remove(Review review) {
		return super.remove(review);

	}

	@Override
	public Review getById(String reviewId) {
		return super.verifyNamedQueryAll("com.ebook.dao.review.impl.ReviewDaoImpl.getById", reviewId);
	}
}