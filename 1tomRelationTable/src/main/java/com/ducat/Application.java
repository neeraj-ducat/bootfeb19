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
		CourseDao dao=(CourseDao)ctx.getBean("courseDao");
		System.out.println("Saving two courses...");
		Set<Topic> s1=new HashSet<Topic>();
		s1.add(new Topic("IOC",25));
		s1.add(new Topic("AOP",25));
		s1.add(new Topic("MVC",50));
		Set<Topic> s2=new HashSet<Topic>();
		s2.add(new Topic("Persistence Operations",25));
		s2.add(new Topic("IS-A Relation",25));
		s2.add(new Topic("Has-A Relation",50));
		Course c1=new Course("Spring",8000,s1);
		Course c2=new Course("Hibernate",7000,s2);
		dao.save(c1);
		dao.save(c2);
		System.out.println("Successfully saved.");
		System.out.println("Fetching all Courses...");
		Iterable<Course> itr=dao.findAll();
		for(Course c : itr)
			{
			
			     System.out.println("Course: "+c.getName()+"\tFee: "+c.getFee());
			     System.out.println("Topic\tWeightage");
				 Set<Topic> set=c.getTopics();
				 for(Topic t: set)
				 System.out.println(t.getName()+"\t"+t.getWeightage());
			 
			}
			
	}

}
