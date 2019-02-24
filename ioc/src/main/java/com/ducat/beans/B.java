package com.ducat.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class B {

	public B() {
		System.out.println("B bean is created.");
	}

	
}
