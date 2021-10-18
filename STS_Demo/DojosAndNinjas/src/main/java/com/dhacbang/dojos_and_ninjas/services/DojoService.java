package com.dhacbang.dojos_and_ninjas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhacbang.dojos_and_ninjas.models.Dojo;
import com.dhacbang.dojos_and_ninjas.repos.DojoRepo;

@Service
public class DojoService {
	@Autowired
	private DojoRepo repo;
	
	//Create/Update_____________________________
	
	public Dojo save(Dojo d) {
		return repo.save(d);
	}
	
	//Read______________________________________
	
	
	
	
	//Delete____________________________________
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	//Relationships_____________________________
	
}
