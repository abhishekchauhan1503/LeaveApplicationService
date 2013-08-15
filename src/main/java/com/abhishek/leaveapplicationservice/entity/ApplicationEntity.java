package com.abhishek.leaveapplicationservice.entity;

import java.util.Date;

public class ApplicationEntity {

	private long id;

	private UserEntity from;
	private UserEntity to;

	private String content;
	private Date submissionDate;

	private char status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserEntity getFrom() {
		return from;
	}

	public void setFrom(UserEntity from) {
		this.from = from;
	}

	public UserEntity getTo() {
		return to;
	}

	public void setTo(UserEntity to) {
		this.to = to;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

}
