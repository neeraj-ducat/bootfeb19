package com.ducat.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Two {

	public Two() {
		System.out.println("Two bean is created.");
	}

	
}
