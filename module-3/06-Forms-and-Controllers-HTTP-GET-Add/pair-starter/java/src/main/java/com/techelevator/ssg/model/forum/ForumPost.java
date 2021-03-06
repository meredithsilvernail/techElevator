package com.techelevator.ssg.model.forum;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ForumPost {
	private Long id;
	private String username;
	private String subject;
	private String message;
	private LocalDateTime datePosted;

	public ForumPost() {
	}

	public ForumPost(Long id, String username, String subject, String message, LocalDateTime datePosted) {
		this.id = id;
		this.username = username;
		this.subject = subject;
		this.message = message;
		this.datePosted = datePosted;
	}

	public ForumPost(String username, String subject, String message, LocalDateTime datePosted) {
		this.username = username;
		this.subject = subject;
		this.message = message;
		this.datePosted = datePosted;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(LocalDateTime datePosted) {
		this.datePosted = datePosted;
	}
}
