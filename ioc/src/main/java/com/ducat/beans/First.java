package com.ducat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class First {

	//dependency of First
	
	private Second second;
	
	
	public First() {
		
		System.out.println("First bean is created.");
	}
	@Autowired
	public void setSecond(Second second)
	{
		this.second=second;
		System.out.println("Second is injected into First bean through setter method.");
	}
}
