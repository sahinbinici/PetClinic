package com.dao.mem;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.dao.OwnerRepository;
import com.model.Owner;
@Repository
public class OwnerRepositoryInMem implements OwnerRepository {

	private Map<Long,Owner> ownersMap=new HashMap();
	
	
	public OwnerRepositoryInMem() {
		Owner owner1=new Owner();
		owner1.setId(1L);
		owner1.setFirstName("sahin");
		owner1.setLastName("binici");
		
		Owner owner2=new Owner();
		owner2.setId(2L);
		owner2.setFirstName("yusuf");
		owner2.setLastName("binici");
		
		Owner owner3=new Owner();
		owner3.setId(3L);
		owner3.setFirstName("Ali");
		owner3.setLastName("binici");
		
		ownersMap.put(owner1.getId(), owner1);
		ownersMap.put(owner2.getId(), owner2);
		ownersMap.put(owner3.getId(), owner3);
	}

	@Override
	public List<Owner> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<>(ownersMap.values());
	}

	@Override
	public Owner findById(Long id) {
		// TODO Auto-generated method stub
		return ownersMap.get(id);
	}

	@Override
	public List<Owner> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return ownersMap.values().stream().filter(o->o.getLastName().equals(lastName)).collect(Collectors.toList());
	}

	@Override
	public void createOwner(Owner owner) {
		// TODO Auto-generated method stub
		owner.setId(new Date().getTime());
		ownersMap.put(owner.getId(), owner);
	}

	@Override
	public Owner updateOwner(Owner owner) {
		// TODO Auto-generated method stub
		ownersMap.replace(owner.getId(), owner);
		return owner;
	}

	@Override
	public void deleteOwner(Long id) {
		// TODO Auto-generated method stub
		ownersMap.remove(id);
	}

}
