package com.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.exception.OwnerNotFoundException;
import com.model.Owner;
import com.service.PetClinicService;

@RestController
@RequestMapping("/rest")
public class RestPetClinicController {

	@Autowired
	PetClinicService petClinicService;
	
	@RequestMapping(value="/owners",method=RequestMethod.POST)
	public ResponseEntity<URI> createOwner(@RequestBody Owner owner){
		try {
		petClinicService.createOwner(owner);
		Long id=owner.getId();
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(location).build();
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/owners/{id}")
	public ResponseEntity<?> updateOwner(@PathVariable("id") Long id,@RequestBody Owner updateOwner){
		try {
			Owner owner=petClinicService.findOwner(id);
			owner.setFirstName(updateOwner.getFirstName());
			owner.setLastName(updateOwner.getLastName());
			petClinicService.updateOwner(owner);
			return ResponseEntity.ok().build();
		}catch(OwnerNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/owner/{id}")
	public ResponseEntity<?> deleteOwner(@PathVariable("id") Long id){
		try {
			petClinicService.deleteOwner(id);
			return ResponseEntity.ok().build();
		} catch (OwnerNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@RequestMapping(value="/owners",method=RequestMethod.GET)
	public  ResponseEntity<List<Owner>> getOwners(){
		List<Owner> owners=petClinicService.findOwners();
		return ResponseEntity.ok(owners);
	}
	
	@RequestMapping(value="/owner/",method=RequestMethod.GET)
	public ResponseEntity<List<Owner>> getOwner(@RequestParam("ln") String lastName){
		List<Owner> owners=petClinicService.findOwners(lastName);
		return ResponseEntity.ok(owners);
	}
	
	@RequestMapping(value="/owner/",method=RequestMethod.GET)
	public ResponseEntity<List<Owner>> getOwnerwithName(@RequestParam("fn") String firstName){
		List<Owner> owners=petClinicService.findOwners(firstName);
		return ResponseEntity.ok(owners);
	}
	
	@RequestMapping(value="/owner/{id}",method=RequestMethod.GET)
	public ResponseEntity<Owner> getOwner(@PathVariable("id") Long id){
		Owner owner=petClinicService.findOwner(id);
		return ResponseEntity.ok(owner);
	}
}
