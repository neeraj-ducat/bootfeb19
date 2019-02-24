package com.ducat.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Second {

	public Second() {
		System.out.println("Second bean is created.");
	}

	
}
