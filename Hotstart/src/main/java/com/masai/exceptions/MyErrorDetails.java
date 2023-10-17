package com.masai.exceptions;

import java.time.LocalDateTime;

public class MyErrorDetails {

	
	private String message;
	private LocalDateTime timeStamp=LocalDateTime.now();
	private String description;
	public MyErrorDetails(String message, LocalDateTime timeStamp, String description) {
		super();
		this.message = message;
		this.timeStamp = timeStamp;
		this.description = description;
	}
	public MyErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "MyErrorDetails [message=" + message + ", timeStamp=" + timeStamp + ", description=" + description + "]";
	}
	
	
}
