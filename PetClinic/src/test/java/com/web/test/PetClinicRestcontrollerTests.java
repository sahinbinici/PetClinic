package com.web.test;

import java.awt.List;
import java.net.URI;
import java.util.Map;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.model.Owner;

import junit.framework.Assert;

public class PetClinicRestcontrollerTests {

	private RestTemplate restTemplate;
	
	@Before
	public void setUP() {
		restTemplate=new RestTemplate();
		
	}
	
	@Test
	public void testCreateOwner() {
		Owner owner=new Owner();
		owner.setFirstName("muhammed");
		owner.setLastName("binici");
		
		URI location=restTemplate.postForLocation("http://localhost:8080/rest/owner", owner);
		
		Owner owner2=restTemplate.getForObject(location, Owner.class);
		
		MatcherAssert.assertThat(owner2.getFirstName(), Matchers.equalTo(owner.getFirstName()));
		MatcherAssert.assertThat(owner2.getLastName(), Matchers.equalTo(owner.getLastName()));
	}
	
	@Test
	public void ownerUpdate() {
		Owner owner=restTemplate.getForObject("http://localhost:8080/rest/owner/2", Owner.class);
		
		MatcherAssert.assertThat(owner.getFirstName(), Matchers.equalTo("yusuf"));
		
		owner.setFirstName("muhammed");
		owner=restTemplate.getForObject("http://localhost:8080/rest/owner/{2}", Owner.class);
		
		MatcherAssert.assertThat(owner.getFirstName(), Matchers.equalTo("muhammed"));
	}
	
	@Test
	public void testDeleteOwner() {
		restTemplate.delete("http://localhost:8080/rest/owner/1",Owner.class);
		
		try {
			restTemplate.getForEntity("http://localhost:8080/rest/owner/1", Owner.class);
			Assert.fail("Have not a Owner");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void testGetByOwnerId() {
		ResponseEntity<Owner> response=restTemplate.getForEntity("http://localhost:8080/rest/owners/1", Owner.class);
		
		MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(200));
		MatcherAssert.assertThat(response.getBody().getFirstName(), Matchers.equalTo("sahin"));
	}
	
	@Test
	public void testGetOwnerByLastName() {
		ResponseEntity<List> response=restTemplate.getForEntity("http://localhost:8080/rest/owners?ln=binici",List.class);
		
		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));		
	}
	
	@Test
	public void testGetOwners() {
		
		ResponseEntity<List> response=restTemplate.getForEntity("http://localhost:8080/rest/owners", List.class);
		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
		
		
	}
}
