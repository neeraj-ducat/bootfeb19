package com.ducat.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ducat.entities.*;

@Repository
public interface HeadOfStateDao extends 
		CrudRepository<HeadOfState, Integer>{

}
