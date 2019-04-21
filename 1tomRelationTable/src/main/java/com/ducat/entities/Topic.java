package com.ducat.entities;

import javax.persistence.*;

//Owned entity class
@Entity
@Table(name="Topics")
public class Topic {

	//state
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private int weightage;
	
	
	
	public Topic() {
		super();
		}
	public Topic(String name, int weightage) {
		super();
		this.name = name;
		this.weightage = weightage;
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
	public int getWeightage() {
		return weightage;
	}
	public void setWeightage(int weightage) {
		this.weightage = weightage;
	}
	
	
}
