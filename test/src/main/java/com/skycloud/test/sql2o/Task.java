package com.skycloud.test.sql2o;

import java.util.Date;

public class Task {

	private Long id;
	private String description;
	private Date dueDate;

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
}