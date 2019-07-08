package org.jb.rest.service;

import java.lang.invoke.MethodHandles;

import org.apache.commons.lang3.RandomStringUtils;
import org.jb.rest.data.PersonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class RestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@GetMapping("/persondetails/{id}/{name}")
	public PersonData getBook(@PathVariable int id, @PathVariable String name) {
		//PersonData personData = new PersonData();
		
	    String address = RandomStringUtils.randomAlphanumeric(10, 20);
	    String phone = RandomStringUtils.randomNumeric(10);
	    String dob = RandomStringUtils.randomNumeric(8);
	    String descr = "Details for : " + name + " # " + id;
	    
	    PersonData personData = PersonData.builder().setAddress(address).setPhone(phone).setDateOfBirth(dob).setDescr(descr).build();

		return personData;
	}
}
