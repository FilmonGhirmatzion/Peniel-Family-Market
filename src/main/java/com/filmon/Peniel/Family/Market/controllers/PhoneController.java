package com.filmon.Peniel.Family.Market.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmon.Peniel.Family.Market.models.Phone;
import com.filmon.Peniel.Family.Market.repositories.PhoneRepository;

@RestController
//@RequestMapping("/api/v1/Phone")
public class PhoneController {
	
	@Autowired
	private PhoneRepository phoneReposiroty ;
	
	@GetMapping 
	public List<Phone> list(){		
		//List<Phone> phone = new ArrayList<>();
		//return phone;
		return phoneReposiroty.findAll();
		
	}
	@PostMapping (path="/create", produces="application/json")
	public void create(@RequestBody Phone phone){
		phoneReposiroty.save(phone);
		
	}
	@GetMapping("/{id}")
	public Phone get(@PathVariable("id") long id) {
		//return new Phone();
		return phoneReposiroty.getOne(id);
	}

}
