package com.example.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Repo.Login_Repo;
import com.example.demo.model.Login_Details;


@Controller
public class Login_Controller {
	
	@Autowired
	Login_Repo login_repo;
	
	@Autowired
	Login_Details user;
	
	
	    @Autowired
	    protected MongoTemplate mongoTemplate;

	
	@RequestMapping("/login")
	public ModelAndView showform(@RequestParam("Username") String Username,@RequestParam("Password") String Password)
	{
	//	user=login_repo.findByUsername("Deepak");
	
		ModelAndView ab=new ModelAndView();
		ab.setViewName("Welcome");
        user=login_repo.findByUsername(Username);
	if(user==null)
		System.out.println("Not-Verified");
	else
		{if(Password.equals(user.getpassword()))
			{System.out.println("Verified");
			
			ab.addObject("name",user.getusername());
			
			}
		
		else
		{
			
		
			
			
			//Updating the data without replacing the old document in database
			Query query = new Query();
			query.addCriteria(Criteria.where("username").is(Username));
			Update update = new Update();
			update.set("times", user.gettimes()+1);
			mongoTemplate.updateFirst(query, update, Login_Details.class);
			
			
			
			//Updating the data with new object id in DB
			//login_repo.deleteByUsername(Username);
			//user.settimes(user.gettimes()+1);
			//mongoTemplate.save(user);
			//login_repo.save(user);
			
			

		return ab;
		}
		}
	return ab;
	

	}
	
	@RequestMapping("/")
	public String Show()
	{
		return "Home";
	}
	
	

	
	

	

}
