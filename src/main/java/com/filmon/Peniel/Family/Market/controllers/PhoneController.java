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
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PhoneController {
	
	private PhoneDAO phoneDAO;
	
	public PhoneController(PhoneDAO phoneDAO) {
		this.phoneDAO = phoneDAO;
	}
	

	@RequestMapping(path="/phone-list", method=RequestMethod.GET)
	public List<Phone> list(){	
		
		return phoneDAO.findAll();
		
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

	@RequestMapping(path="phone-delete/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable(name="id") long id) {
		phoneDAO.deleteById(id);
	}

	@RequestMapping(path="phone-update", method=RequestMethod.PUT)
	public void update(@PathVariable int id, @RequestBody Phone phone) {
		phoneDAO.update(phone);
	}

}
