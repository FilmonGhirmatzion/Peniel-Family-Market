package com.filmon.Peniel.Family.Market.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.filmon.Peniel.Family.Market.models.Phone;
// import com.filmon.Peniel.Family.Market.repositories.PhoneRepository;
import com.filmon.Peniel.Family.Market.services.PhoneDAO;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/phones")
public class PhoneController {

	private static Logger logger = LoggerFactory.getLogger(PhoneController.class);
	
	private final PhoneDAO phoneDAO;
	
	public PhoneController(PhoneDAO phoneDAO) {
		this.phoneDAO = phoneDAO;
	}
	

	// @GetMapping("/list")
	// public List<Phone> list(){	
		
	// 	return phoneDAO.findAll();
		
	// }
	@GetMapping("/list")
    public List<Phone> list() {
        logger.info("Request received to list all phones");
        List<Phone> phones = phoneDAO.findAll();
        logger.info("Returning list of phones: {}", phones);
        return phones;
    }

	@PostMapping("/create")
	public Phone create(@RequestBody Phone phone){
		return phoneDAO.create(phone);
		
	}
	@GetMapping("/get/{id}")
	public Phone get(@PathVariable(name="id") long id) {
		Phone phone = phoneDAO.findById(id);

		return phone;
		
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(name="id") long id) {
		phoneDAO.deleteById(id);
	}

	@PutMapping("/update/{id}")
	public void update(@PathVariable int id, @RequestBody Phone phone) {
		phoneDAO.update(phone);
	}

}
