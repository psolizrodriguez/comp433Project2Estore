package com.ebook.service.item;

import java.util.List;

import com.ebook.model.item.Review;

public interface ReviewService {
	public Review save(Review review);

	public List<Review> listAll();

	public Review getById(Long reviewId);

	public boolean remove(Review review);
}
