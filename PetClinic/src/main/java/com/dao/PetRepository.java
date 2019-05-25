package com.dao;

import java.util.List;

import com.model.Pet;

public interface PetRepository {

	Pet findById(Long id);
	List<Pet> findByOwnerId(Long ownerId);
	void createPet(Pet pet);
	Pet updatePet(Pet pet);
	void deletePet(Long id);
	void deleteByOwnerId(Long ownerId); 
}
