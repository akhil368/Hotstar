package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Content;
import com.masai.model.User;
import com.masai.repository.HotstarRepoImpl;

@Service
public class HotstartServiceImpl implements HotstarService {

	@Autowired
	private HotstarRepoImpl repo;
	
	
	@Override
	public Content addContent(Content c) {
		// TODO Auto-generated method stu
		return repo.addContent(c);
	}

	@Override
	public List<Content> viewAllContent() {
		// TODO Auto-generated method stub
		return repo.viewAllContent();
	}

	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		return repo.addUser(u);
	}

	@Override
	public String chooseContent(int contentId, int userId) {
		// TODO Auto-generated method stub
		
		return repo.chooseContent(contentId, userId);
				
	}

	@Override
	public List<User> browseUser() {
		// TODO Auto-generated method stub
		return repo.browseUser();
	}

	@Override
	public List<Content> recommend(int contentId) {
		// TODO Auto-generated method stub
		System.out.println(repo.recommend(contentId));
		return repo.recommend(contentId);
	}

}
