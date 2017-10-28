package com.ebook.dao.item;

import java.util.List;

import com.ebook.common.dao.Dao;
import com.ebook.model.item.Review;

public interface ReviewDao extends Dao {
	public Review save(Review review);

	public List<Review> listAll();

	public Review getById(Long reviewId);

	public boolean remove(Review review);
}
