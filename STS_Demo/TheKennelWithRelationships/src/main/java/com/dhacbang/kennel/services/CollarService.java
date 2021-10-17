package com.dhacbang.kennel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhacbang.kennel.models.Collar;
import com.dhacbang.kennel.repos.CollarRepo;

@Service
public class CollarService {
	@Autowired
	private CollarRepo repo;
	
	//Create/Update_____________________________
	
	public Collar save(Collar c) {
		return repo.save(c);
	}
	
	//Read______________________________________
	
	
	
	
	//Delete____________________________________
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	//Relationships_____________________________
	
}
