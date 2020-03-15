package com.techelevator.model;

import java.time.LocalDateTime;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotBlank;

public class Review {
	private Long id;

	@NotBlank(message = "Name is required")
	private String username;

	@Min(value = 1, message = "Rating must be at least 1 star")
	@Max(value = 5, message = "Rating must be 5 stars or less")
	private int rating;

	@NotBlank(message = "Title is required")
	private String title;

	@NotBlank(message = "Message is required")
	private String text;

	private LocalDateTime dateSubmitted;

	public Review() {
	}

	public Review(String username, int rating, String title, String text, LocalDateTime dateSubmitted) {
		this.username = username;
		this.rating = rating;
		this.title = title;
		this.text = text;
		this.dateSubmitted = dateSubmitted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(LocalDateTime dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
}
