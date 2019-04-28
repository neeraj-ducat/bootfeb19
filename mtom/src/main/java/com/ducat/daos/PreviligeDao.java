package com.ducat.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ducat.entities.*;

@Repository
public interface PreviligeDao extends 
				JpaRepository<Previlige, Integer>{

}
