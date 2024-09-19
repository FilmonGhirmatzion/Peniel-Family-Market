package com.filmon.Peniel.Family.Market.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filmon.Peniel.Family.Market.models.Phone;
// import com.filmon.Peniel.Family.Market.repositories.PhoneRepository;
import com.filmon.Peniel.Family.Market.services.PhoneDAO;

@RestController
public class PhoneController {
	
	private PhoneDAO phoneDAO;
	
	public PhoneController(PhoneDAO phoneDAO) {
		this.phoneDAO = phoneDAO;
	}
	@GetMapping 
	public List<Phone> list(){		
		List<Phone> phone = new ArrayList<>();
		return phone;
		// return phoneReposiroty.findAll();
		
	}
	 @RequestMapping(path="/create-phone", method= RequestMethod.POST)
	public Phone create(@RequestBody Phone phone){
		return phoneDAO.create(phone);
		
	}
	@RequestMapping(path="phone-get-byId/{id}", method=RequestMethod.GET)
	public Phone get(@PathVariable(name="id") long id) {
		Phone phone = phoneDAO.findById(id);

		return phone;
		
	}

}
