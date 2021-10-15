package com.dhacbang.pokeBook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhacbang.pokeBook.models.Item;
import com.dhacbang.pokeBook.repos.ItemRepo;

@Service
public class ItemService {
//	private final DogRepo repo;
//	
//	public DogService(DogRepo r) {
//		this.repo = r;
//	}

	@Autowired
	private ItemRepo repo;
	
	//Create/Update_____________________________
	
	public Item save(Item i) {
		return repo.save(i);
	}
	
	
	
	//Read______________________________________
	
	public List<Item> getAll(){
		return repo.findAll();

	}
	
	public Item getOne(Long id) {
		Optional<Item> i = repo.findById(id);
		if (i.isPresent()) {
			return i.get();
		} else {
			return null;
		}
	}
	
	//Delete____________________________________
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
