package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.beans.ABC;

@SpringBootApplication
public class Application {

	public static void main(String arr[])
	{
		//Application is bootstraped
	  ApplicationContext ctx=	SpringApplication.run(Application.class, arr);
	  System.out.println("Application is started, requesting ABC object from the contaner...");
	  ABC target=(ABC)ctx.getBean("one");
	  System.out.println("Invoking a() of target...");
	  target.a();
	  System.out.println("Invoking b() of target...");
	  String result=target.b();
	  System.out.println(result+" is returned by b() of target.");
	}
}
