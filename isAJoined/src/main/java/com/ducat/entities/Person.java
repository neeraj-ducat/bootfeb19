package com.ducat.entities;

import javax.persistence.Entity;
import javax.persistence.*;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	
	public Person() {
		super();
	}
	public Person(String name) {
		super();
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
