package com.masai.model;

import java.util.Objects;

public class Content implements Comparable<Content>{

	
	private int contentId;
	private String title;
	private String description;
	private String category;
	private int duration;
	
	
	
	
	@Override
	public int compareTo(Content o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.contentId, o.contentId);
	}




	public Content() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Content(int contentId, String title, String description, String category, int duration) {
		super();
		this.contentId = contentId;
		this.title = title;
		this.description = description;
		this.category = category;
		this.duration = duration;
	}




	@Override
	public int hashCode() {
		return Objects.hash(category, contentId, description, duration, title);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Content other = (Content) obj;
		return Objects.equals(category, other.category) && contentId == other.contentId
				&& Objects.equals(description, other.description) && duration == other.duration
				&& Objects.equals(title, other.title);
	}




	public int getContentId() {
		return contentId;
	}




	public void setContentId(int contentId) {
		this.contentId = contentId;
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




	public String getCategory() {
		return category;
	}




	public void setCategory(String category) {
		this.category = category;
	}




	public int getDuration() {
		return duration;
	}




	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
	

}
