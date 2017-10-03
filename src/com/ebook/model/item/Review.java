package com.ebook.model.item;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.ebook.model.customer.Customer;

@Entity
public class Review {
	@Id
	private String reviewId;
	private String title;
	private String description;
	private Integer rating;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private Customer customer;

	public Review() {

	}

	public Review(String reviewId, String title, String description, Integer rating, Customer customer) {
		this.reviewId = reviewId;
		this.title = title;
		this.description = description;
		this.rating = rating;
		this.customer = customer;
	}

	public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
