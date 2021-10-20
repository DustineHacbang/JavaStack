package com.dhacbang.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dhacbang.models.Pokemon;

@Repository
public interface PokeRepo extends CrudRepository<Pokemon, Long>{
	List<Pokemon> findAll();
}
