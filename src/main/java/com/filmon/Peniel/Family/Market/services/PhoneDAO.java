package com.filmon.Peniel.Family.Market.services;

import java.util.List;

import com.filmon.Peniel.Family.Market.models.Phone;

public interface PhoneDAO {
    Phone create(Phone phone); 
    Phone findById(Long id); 
    List<Phone> findAll();   
    void update(Phone phone); 
    void deleteById(Long id); 

}
