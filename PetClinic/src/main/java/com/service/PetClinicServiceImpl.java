package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.OwnerRepository;
import com.exception.OwnerNotFoundException;
import com.model.Owner;
@Service
public class PetClinicServiceImpl implements PetClinicService {

	OwnerRepository ownerRepository;
	
	@Autowired
	public void setOwnerRepository(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@Override
	public List<Owner> findOwners() {
		// TODO Auto-generated method stub
		return ownerRepository.findAll();
	}

	@Override
	public List<Owner> findOwners(String lastName) {
		// TODO Auto-generated method stub
		return ownerRepository.findByLastName(lastName);
	}

	@Override
	public Owner findOwner(Long id) throws OwnerNotFoundException {
		// TODO Auto-generated method stub
		Owner owner=ownerRepository.findById(id);
		if(owner==null) throw new OwnerNotFoundException("Owner bulunamadı:"+id);
		return owner;
	}

	@Override
	public void createOwner(Owner owner) {
		// TODO Auto-generated method stub
		ownerRepository.createOwner(owner);

	}

	@Override
	public void updateOwner(Owner owner) {
		// TODO Auto-generated method stub
		ownerRepository.updateOwner(owner);
	}

	@Override
	public void deleteOwner(Long ownerId) {
		// TODO Auto-generated method stub
		ownerRepository.deleteOwner(ownerId);
	}

}
