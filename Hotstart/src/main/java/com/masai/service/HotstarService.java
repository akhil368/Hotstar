package com.masai.service;

import java.util.List;

import com.masai.model.Content;
import com.masai.model.User;

public interface HotstarService {

public Content addContent(Content c);
	
	public List<Content> viewAllContent();
	
	
	public User addUser(User u);
	
	public String chooseContent(int contentId,int userId);
	
	public List<User> browseUser();
	
	public List<Content> recommend(int contentId);
}
