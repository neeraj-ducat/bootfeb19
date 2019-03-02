package com.ducat.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Lazy
public class Ticket {

	private static int counter;
	private int no;
	
	public Ticket()
	{
		no=++counter;
		System.out.println("Ticket "+no+" is created.");
	}
	public String toString()
	{
		return "It is ticket numbered: "+no;
	}
}
