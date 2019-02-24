package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.beans.*;

@SpringBootApplication
public class MyApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx=SpringApplication.run(MyApplication.class, args);
		System.out.println("Requesting A bean from the container...");
		A a=(A)ctx.getBean("a");
		System.out.println("Requesting One bean from the container...");
		One one=(One)ctx.getBean("one");
		System.out.println("Requesting First bean from the container...");
		First f=(First)ctx.getBean("first");
	}

}
