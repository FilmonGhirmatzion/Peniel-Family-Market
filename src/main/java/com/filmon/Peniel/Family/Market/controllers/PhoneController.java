package com.filmon.Peniel.Family.Market.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmon.Peniel.Family.Market.models.Phone;

@RestController
@RequestMapping("/api/v1/phones")
public class PhoneController {
	
	@GetMapping 
	public List<Phone> list(){
		List<Phone> phone = new ArrayList<>();
		return phone;
		
	}
	@PostMapping 
	public void create(@RequestBody Phone phone){
		
	}
	@GetMapping("/{id}")
	public Phone get(@PathVariable("id") long id) {
		return new Phone();
	}

}
