package com.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dao.OwnerRepository;
import com.model.Owner;
@Repository("ownerRepository")
public class OwnerRepositoryJpaImpl implements OwnerRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Owner> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Owner",Owner.class).getResultList();
	}

	@Override
	public Owner findById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Owner.class, id);
	}

	@Override
	public List<Owner> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return em.createQuery("from owner where lastname=:lastname",Owner.class).setParameter("lastName", lastName).getResultList();
	}

	@Override
	public void createOwner(Owner owner) {
		em.persist(owner);

	}

	@Override
	public Owner updateOwner(Owner owner) {
		// TODO Auto-generated method stub
		return em.merge(owner);
	}

	@Override
	public void deleteOwner(Long id) {
		// TODO Auto-generated method stub
		em.remove(em.getReference(Owner.class, id));
	}

}
