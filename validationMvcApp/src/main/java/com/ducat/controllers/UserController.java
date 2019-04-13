package com.ducat.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ducat.daos.UserDao;
import com.ducat.entities.User;
import com.ducat.validators.MailValidator;

@Controller
public class UserController {

	@Autowired
	private UserDao dao;
	
	@Autowired
	private MailValidator mailValidator;
	
	@Autowired
	private HttpSession session;
	
	//method to process the request for home page
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	//method to serve registration form
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public ModelAndView regForm()
	{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("registerForm");
		mav.addObject("user", new User());
		return mav;
	}
	
	
	
	//method to process the register form
		@RequestMapping(value="/register",method=RequestMethod.POST)
		public ModelAndView register(
			@Valid	@ModelAttribute User user,
			BindingResult br)throws Exception
		{
			//custom validation is performed
			mailValidator.validate(user, br);
			
			ModelAndView mav=new ModelAndView();
			mav.addObject("user",user);
			if(br.hasErrors())
			{
				mav.setViewName("registerForm");
			}
			else
			{	
			dao.save(user);
			mav.setViewName("registered");
			
			}
			return mav;
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
