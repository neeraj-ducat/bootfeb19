package com.ducat.entities;

import java.util.Set;

import javax.persistence.*;


//Owned entity class
@Entity
@Table(name="Previliges")
public class Previlige {

	//state
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String name;
	int cost;
	@ManyToMany(mappedBy="previliges",fetch=FetchType.EAGER)
	Set<Emp> employees;
	
	public Previlige() {
		super();
		
	}
	public Previlige(String name, int cost) {
		super();
		this.name = name;
		this.cost = cost;
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
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public Set<Emp> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Emp> employees) {
		this.employees = employees;
	}
	
	
	
}
