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
		CourseDao cdao=(CourseDao)ctx.getBean("courseDao");
		
		/*
		System.out.println("Saving courses...");
		Course c1=new Course("Spring",8000);
		Course c2=new Course("Hibernate",7000);
		cdao.save(c1);
		cdao.save(c2);
		System.out.println("Saved.");*/
		//loading courses
		Course c1=cdao.findById(1).get();
		Course c2=cdao.findById(2).get();
		TopicDao dao=(TopicDao)ctx.getBean("topicDao");
		System.out.println("Saving some topics");
		Topic t1=new Topic("IOC",25,c1);
		Topic t2=new Topic("AOP",25,c1);
		Topic t3=new Topic("MVC",50,c1);
		Topic t4=new Topic("Persistence Operations",25,c2);
		Topic t5=new Topic("IS-A Relation",25,c2);
		Topic t6=new Topic("Has-A Relation",50,c2);
	
		dao.save(t1);
		dao.save(t2);
		dao.save(t3);
		dao.save(t4);
		dao.save(t5);
		dao.save(t6);
		System.out.println("Successfully saved.");
		/*System.out.println("Fetching Topics...");
		Iterable<Topic> itr=dao.findAll();
		System.out.println("Topic\tWeightage\tCourse");
		for(Topic t: itr)
			{
			
			   Course course=t.getCourse();
				System.out.println(t.getName()+"\t"+t.getWeightage()
				+"\t"+course.getName());
			 
			}
			*/
	}

}
