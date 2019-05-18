package com.example.demo.Repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;


import com.example.demo.model.Login_Details;


public interface Login_Repo extends MongoRepository<Login_Details, String> {
	
	
	
	
	
	 

	public Login_Details findByPassword(String password);

	public Login_Details findByUsername(String string);
	
	@DeleteQuery
	public void deleteByUsername(String user);

		
	
}
