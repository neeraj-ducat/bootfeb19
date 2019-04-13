package com.ducat.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.daos.EmpDao;
import com.ducat.entities.Emp;

@RestController
@RequestMapping("/employees")
public class EmpController {

	@Autowired
	EmpDao dao;
	
	//Method to save Emp
	@PostMapping(value="/",consumes={"application/json"})
	public String save(@RequestBody Emp e)
	{
		dao.save(e);
		return "saved.";
	}
	
	//Method to update Emp
		@PutMapping(value="/",consumes={"application/json"})
		public String update(@RequestBody Emp e)
		{
			dao.save(e);
			return "saved.";
		}
	
	//Method to return an Emp using id
		@GetMapping(value="/{id}",produces= {"application/json"})
		public Emp getById(@PathVariable int id)
		{
			Emp e=null;
			Optional<Emp> op=dao.findById(id);
			if(op.isPresent())
				e=op.get();
			return e;
		}
		
		//Method to delete an Emp using id
				@DeleteMapping(value="/{id}")
				public String remove(@PathVariable int id)
				{
					dao.deleteById(id);
					return "deleted";
				}
		
		//Method to return all Employees
				@GetMapping(value="/",produces= {"application/json"})
				public Iterable<Emp> getAll()
				{
					
					return dao.findAll();
				}
}
