package com.dhacbang.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhacbang.models.Pokemon;
import com.dhacbang.repos.PokeRepo;

@Service
public class PokeService {
	@Autowired
	private PokeRepo pokeRepo;
	

	
	//____________Create____________
	public Pokemon save(Pokemon p) {
		return pokeRepo.save(p);
	}
	//_____________Read_____________
	public List<Pokemon> getAll(){
		return pokeRepo.findAll();
	}
	
	public Pokemon getOne(Long id) {
		Optional<Pokemon> optionalPoke = pokeRepo.findById(id);
		
		if(optionalPoke.isPresent()) {
			return optionalPoke.get();
		}else {
			return null;
		}
	}
	//____________Delete____________
	
	public void delete(Long id) {
		pokeRepo.deleteById(id);
	}
	
	//________Relationships_________
}
