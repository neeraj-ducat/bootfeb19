package com.ducat.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class A {

	@Autowired
	private B b;

	public A() {
		System.out.println("A object is created.");
	}
	
	@Bean
	private B getB()
	{
		System.out.println("Factory method is invoked.");
		return new B();
	}
	
}
