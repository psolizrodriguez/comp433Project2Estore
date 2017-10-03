package com.ebook.service.item.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.dao.item.ReviewDao;
import com.ebook.model.item.Review;
import com.ebook.service.item.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	ReviewDao dao;

	@Override
	public Review save(Review review) {
		return dao.save(review);
	}

	@Override
	public List<Review> listAll() {
		return dao.listAll();
	}

	@Override
	public Review getById(String reviewId) {
		return dao.getById(reviewId);
	}

	@Override
	public boolean remove(Review review) {
		return dao.remove(review);
	}

}
