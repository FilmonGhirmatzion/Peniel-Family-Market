package com.filmon.Peniel.Family.Market.services;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.filmon.Peniel.Family.Market.models.Phone;
import com.filmon.Peniel.Family.Market.services.PhoneDAO;
import com.filmon.Peniel.Family.Market.models.Phone;


@Component
public class JdbcPhone implements PhoneDAO {

    private JdbcTemplate jdbcTemplate;  

    public JdbcPhone(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Phone create(Phone phone) {
        String sql = "INSERT INTO phone (name, brand, model, phone_number, serial_number, os, email, storage_capacity, ram_size, is_5g, price, purchase_date, contact_person, contact) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, 
           phone.getName(),
           phone.getBrand(), 
           phone.getModel(), 
           phone.getPhoneNumber(),
           phone.getSerialNumber(), 
           phone.getOs(),
           phone.getEmail(), 
           phone.getStorageCapacity(), 
           phone.getRamSize(), 
           phone.is5G(),
           phone.getPrice(), 
           phone.getPurchaseDate(), 
           phone.getContactPerson(), 
           phone.isContact()
        );
        return phone;
        
    }

    @Override
    public Phone findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Phone> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(Phone phone) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        
    }

    
    
}