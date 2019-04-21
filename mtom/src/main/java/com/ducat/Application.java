package com.ducat;

import java.util.HashSet;
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
		EmpDao dao=(EmpDao)ctx.getBean("empDao");
		System.out.println("Saving Employees...");
		Previlige p1=new Previlige("Car",120000);
		Previlige p2=new Previlige("Flat",360000);
		Previlige p3=new Previlige("Club Membership",600000);
		Set<Previlige> s1=new HashSet<Previlige>();
		s1.add(p1);s1.add(p2);s1.add(p3);
		Set<Previlige> s2=new HashSet<Previlige>();
		s2.add(p1);s2.add(p2);
		Set<Previlige> s3=new HashSet<Previlige>();
		s3.add(p1);
		
		Emp e1=new Emp("Raman","Manager",99000,s1);
		Emp e2=new Emp("Manoj","HOD",90000,s2);
		Emp e3=new Emp("Vipul","Tech Lead",85000,s3);
		dao.save(e1);
		dao.save(e2);
		dao.save(e3);
		System.out.println("Successfully saved.");
		System.out.println("Fetching Employees...");
		Iterable<Emp> itr=dao.findAll();
		for(Emp e : itr)
			{
			
			     System.out.println(e.getName()+"\t"+
			     e.getJob()+"\t"+e.getSalary());
			     System.out.println("Availed previliges");
				 Set<Previlige> set=e.getPreviliges();
				 for(Previlige p: set)
				 System.out.println(p.getName()+"\t"+p.getCost());
			 
			}
			
	}

}
