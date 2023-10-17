package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Content;
import com.masai.model.User;
import com.masai.service.HotstartServiceImpl;

import jakarta.validation.Valid;

@RestController
public class HotstarController {

	@Autowired
	private HotstartServiceImpl service;
	
	@PostMapping("/users")
	public ResponseEntity<String> addUser(@Valid @RequestBody User u)
	{
		service.addUser(u);
		return new ResponseEntity<>("User added Successfully",HttpStatus.CREATED);
	}
	

	@PostMapping("/contents")
	public ResponseEntity<String> registerUser(@Valid  @RequestBody Content c){
		service.addContent(c);
		return new ResponseEntity<>("Content added Successfully" , HttpStatus.CREATED) ;
	}
	
	@GetMapping("/contents")
	public ResponseEntity<List<Content>> browseContent()
	{
		return new ResponseEntity<>(service.viewAllContent(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> browseUser()
	{
		return new ResponseEntity<>(service.browseUser(),HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/users/{contentId}/{userId}")
	public ResponseEntity<String> chooseContentToStream(@PathVariable Integer contentId,@PathVariable  Integer userId)
	{
		
		return  new ResponseEntity<>(service.chooseContent(contentId, userId),HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/contents/{contentId}")
	public ResponseEntity<List<Content>> provideRecommendations(@PathVariable Integer contentId)
	{
		return new ResponseEntity<>(service.recommend(contentId),HttpStatus.ACCEPTED);
	}
	
	
}
