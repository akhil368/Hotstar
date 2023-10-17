package com.masai.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Repository;

import com.masai.exceptions.HostarException;
import com.masai.exceptions.InvalidDataException;
import com.masai.exceptions.NotFoundException;
import com.masai.model.Content;
import com.masai.model.User;

import jakarta.annotation.PostConstruct;

@Repository
public class HotstarRepoImpl implements HostartRepo {

	
	TreeSet<Content> con;
	
	TreeSet<User> user;
	@PostConstruct
	public void init()
	{
		 con=new TreeSet<>();
		 user=new TreeSet<>();
		Content contentOne=new Content(1,"3 Idiots","movie of three engineers","Movie",3);
		Content contentTwo=new Content(2,"Bahubali","web ","Web Series",3);
		Content contentThree=new Content(3,"K.G.F","three engineers","Web Series",5);
		Content four=new Content(4,"ABC","asds","Movie",4);
		
		con.add(contentOne);
		con.add(contentTwo);
		con.add(contentThree);
		
		User userOne=new User(1,"ABC","akhil@gmail.com",con);
		
		
		user.add(userOne);
		
	}
	
	@Override
	public Content addContent(Content c) {
		// TODO Auto-generated method stub
		if(c==null) throw new InvalidDataException("Content is null");
		if(con.contains(c))
		{
			throw new HostarException("Content Already Exists");
		}
		con.add(c);
		return c;
	}

	@Override
	public List<Content> viewAllContent() {
		// TODO Auto-generated method stub
		
		List<Content> list=new ArrayList<>();
		if(con.isEmpty())
		{
			throw new NotFoundException("Content List is EMpty");
		}
		for(Content c :con)
		{
			list.add(c);
		}
		return list;
	}

	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		if(u==null) throw new HostarException("User data is Empty");
		if(user.contains(u))
		{
			throw new HostarException("User Already Exists");
		}
		user.add(u);
		return u;
	}

	@Override
	public String chooseContent(int contentId,int userId) {
		// TODO Auto-generated method stub
		User u=null;
//		Content c = null;
		for(User us:user)
		{
			if(us.getUserId()==userId)
			{
				u=new User(us.getUserId(),us.getName(),us.getEmail(),us.getContentToStream());
		
			}
			
		}
		TreeSet<Content> content=new TreeSet<>();
		for(Content co:con)
		{
			if(co.getContentId()==contentId)
			{
				u.setContentToStream(content);
			}
			
		}
		
		
		return "Content Choosed Successfully";
	}

	@Override
	public List<User> browseUser() {
		if(user.isEmpty())
		{
			throw new HostarException("No User found");
		}
		List<User> list=new ArrayList<>();
		for(User u:user)
		{
			list.add(u);
		}
		return list;
	}

	@Override
	public List<Content> recommend(int contentId) {
		// TODO Auto-generated method stub
		List<Content> list=new ArrayList<>();
		Content c = null;
		for(Content co:con)
		{
			if(co.getContentId()==contentId)
			{
				c=new Content(co.getContentId(),co.getTitle(),co.getDescription(),co.getCategory(),co.getDuration());
				
			}
			
		}
		
		String category=c.getCategory();
		for(Content co:con)
		{
			if(co.getCategory().contains(category))
			{
				list.add(co);
			
			}
			
		}
		if(list.isEmpty())
		{
			throw new NotFoundException("User haven't watched anything");
		}
		return list;
	}

}
