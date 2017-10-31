package com.ebook.model.item;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Book extends Product {
	private String isbn;
	private String author;

	public Book(Long productId, String title, String description, List<Review> review, String isbn, String author) {
		super(productId, title, description, review);
		this.isbn = isbn;
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Book() {
	}

	public String getISBN() {
		return isbn;
	}

	public void setISBN(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
