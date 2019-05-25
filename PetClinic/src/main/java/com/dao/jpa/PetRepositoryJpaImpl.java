package com.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.PetRepository;
import com.model.Pet;
@Repository("petRepository")
public class PetRepositoryJpaImpl implements PetRepository {
	
	@Autowired
	private EntityManager em;
	
	@Override
	public Pet findById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Pet.class, id);
	}

	@Override
	public List<Pet> findByOwnerId(Long ownerId) {
		// TODO Auto-generated method stub
		return em.createQuery("from pet where owner.id=: ownerId",Pet.class).setParameter("ownerId", ownerId).getResultList();
	}

	@Override
	public void createPet(Pet pet) {
		em.persist(pet);

	}

	@Override
	public Pet updatePet(Pet pet) {
		// TODO Auto-generated method stub
		return em.merge(pet);
	}

	@Override
	public void deletePet(Long id) {
		// TODO Auto-generated method stub
		em.remove(em.getReference(Pet.class, id));

	}

	@Override
	public void deleteByOwnerId(Long ownerId) {
		em.createQuery("from Pet where owner.id=: ownerId",Pet.class).setParameter("ownerId",ownerId).executeUpdate();

	}

}
