package com.dhacbang.kennel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhacbang.kennel.models.Dog;
import com.dhacbang.kennel.repos.DogRepo;

@Service
public class DogService {
//	private final DogRepo repo;
//	
//	public DogService(DogRepo r) {
//		this.repo = r;
//	}

	@Autowired
	private DogRepo repo;
	
	//Create/Update_____________________________
	
	public Dog save(Dog d) {
		return repo.save(d);
	}
	
	
	
	//Read______________________________________
	
	public List<Dog> getAll(){
		return repo.findAll();

	}
	
	public Dog getOne(Long id) {
		Optional<Dog> d = repo.findById(id);
		if (d.isPresent()) {
			return d.get();
		} else {
			return null;
		}
	}
	
	//Delete____________________________________
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	//Relationships_____________________________
}
