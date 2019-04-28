package com.ducat;

import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ducat.daos.*;
import com.ducat.entities.*;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ApplicationContext ctx=SpringApplication.run(Application.class, args);
		CountryDao dao=(CountryDao)ctx.getBean("countryDao");
		System.out.println("Saving country objects...");
		Country c1=new Country("India",new HeadOfState("President","R.N.Kovind"));
		Country c2=new Country("UK",new HeadOfState("Queen","Elizabeth II"));
		dao.save(c1);
		dao.save(c2);
		System.out.println("Successfully saved.");
		System.out.println("Fetching all Countries...");
		Iterable<Country> itr=dao.findAll();
		System.out.println("Country\tHOS Title\tHos Name");
		for(Country c : itr)
			{
			
				 HeadOfState hos=c.getHos();
				 System.out.println(c.getName()+"\t"+
				 hos.getTitle()+"\t"+hos.getName());
			 
			}
		System.out.println("Fetching Head of states...");
		System.out.println("HOS Title\tHos Name\tCountry");
		HeadOfStateDao hdao=(HeadOfStateDao)ctx.getBean("headOfStateDao");
		Iterable<HeadOfState> hitr=hdao.findAll();
		for(HeadOfState h : hitr)
			{
			
				 Country c=h.getCountry();
				 System.out.println(
				 h.getTitle()+"\t"+h.getName()
				 +"\t"+c.getName());
			 
			}
			
	}

}
