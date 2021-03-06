package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.beans.*;

@SpringBootApplication
public class MyApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx=SpringApplication.run(MyApplication.class, args);
		System.out.println("Requesting conductor from the container...");
		//Conductor con=(Conductor)ctx.getBean("dishonestConductor");
		//Conductor con=(Conductor)ctx.getBean("honestConductor");
		Conductor con=(Conductor)ctx.getBean("conductor");
		System.out.println("Auto generated class is: "+con.getClass().getName());
		System.out.println("Requesting Two tickets from the conductor...");
		Ticket t1=con.getTicket();
		Ticket t2=con.getTicket();
		System.out.println("Details of First Ticket "+t1);
		System.out.println("Details of Second Ticket "+t2);
	
		//It is optional part and is added to demonstrate
		//the use of factory method.
		System.out.println("Requesting A bean from the container...");
		A a=(A)ctx.getBean("a");
	}

}
