package com.ducat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class A {

	//dependency of A
	@Autowired
	private B b;
	
	public A() {
		System.out.println("A bean is created.");
	}

	
}
