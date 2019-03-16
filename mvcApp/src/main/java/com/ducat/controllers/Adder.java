package com.ducat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Adder {

	
	//Method to process the initial request
	@RequestMapping("/adder/")
	public String home()
	{
		System.out.println("home() of controller is invoked.");
		return "index";
	}
	
	//Method to process the add request
		@RequestMapping(value="/adder/add",
				method=RequestMethod.POST)
		public ModelAndView  doSum(
			@RequestParam("num1")	int x, 
			@RequestParam("num2") int y)
		{
			int z=x+y;
			ModelAndView mav=new ModelAndView();
			mav.addObject("sum",z);
			mav.setViewName("result");
			return mav;
		}
}
