package com.dhacbang.dojos_and_ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhacbang.dojos_and_ninjas.models.Ninja;
import com.dhacbang.dojos_and_ninjas.repos.NinjaRepo;

@Service
public class NinjaService {
//	private final DogRepo repo;
//	
//	public DogService(DogRepo r) {
//		this.repo = r;
//	}

	@Autowired
	private NinjaRepo repo;
	
	//Create/Update_____________________________
	
	public Ninja save(Ninja n) {
		return repo.save(n);
	}
	
	
	
	//Read______________________________________
	
	public List<Ninja> getAll(){
		return repo.findAll();

	}
	
	public Ninja getOne(Long id) {
		Optional<Ninja> n = repo.findById(id);
		if (n.isPresent()) {
			return n.get();
		} else {
			return null;
		}
	}
	
	//Delete____________________________________
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	
}
