package com.masai.model;

import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

import jakarta.validation.constraints.Email;

public class User implements Comparable<User>{

	private int userId;
	
	private String name;
	
	@Email
	private String email;
	
	private TreeSet<Content> contentToStream;
	
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(contentToStream, email, name, userId);
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(contentToStream, other.contentToStream) && Objects.equals(email, other.email)
				&& Objects.equals(name, other.name) && userId == other.userId;
	}





	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", contentToStream=" + contentToStream
				+ "]";
	}





	public int getUserId() {
		return userId;
	}





	public void setUserId(int userId) {
		this.userId = userId;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public TreeSet<Content> getContentToStream() {
		return contentToStream;
	}





	public void setContentToStream(TreeSet<Content> contentToStream) {
		this.contentToStream = contentToStream;
	}





	public User(int userId, String name, @Email String email, TreeSet<Content> con) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.contentToStream = con;
	}





	public User() {
		super();
		// TODO Auto-generated constructor stub
	}





	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		
		return Integer.compare(this.userId, o.userId);
	}

}
