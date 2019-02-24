package com.ducat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class One {

	//dependency of One
	
	private Two two;
	
	@Autowired
	public One(Two two) {
		this.two=two;
		System.out.println("One bean is created and Two bean is injected in it.");
	}

	
}
