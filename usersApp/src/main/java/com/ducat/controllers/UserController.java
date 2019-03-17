package com.ducat.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ducat.daos.UserDao;
import com.ducat.entities.User;

@Controller
public class UserController {

	@Autowired
	private UserDao dao;
	
	@Autowired
	private HttpSession session;
	
	//method to process the request for home page
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	//method to process the signup request
		@RequestMapping(value="/register",method=RequestMethod.POST)
		public String register(@ModelAttribute User user)throws Exception
		{
			dao.save(user);
			return "registered";
		}
		//method to process the login request
		@RequestMapping(value="/login",method=RequestMethod.POST)
		public String login(
			@RequestParam	String mailId, 
			@RequestParam String password)throws Exception
		{
					List<User> list=dao.findByMailId(mailId);
					if(!list.isEmpty())
					{
						User user=list.get(0);
						if(user.getPassword().equals(password))
						{
							session.setAttribute("user",user);
							return "dashboard";
						}
					}
					return "relogin";
					
					
		}	
		
}
