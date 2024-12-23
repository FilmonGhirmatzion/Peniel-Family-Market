package com.filmon.Peniel.Family.Market.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

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
        Phone phone =null;
        String sql = "SELECT id, name, brand, model, phone_number, serial_number, os, email, storage_capacity, ram_size, is_5g, price, purchase_date, contact_person, contact FROM phone WHERE id =?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, id);
        if (rows.next()) {
            phone = mapRowToPhone(rows);
        }
        return phone;
    }
    private Phone mapRowToPhone(SqlRowSet row) {
        Phone phone = new Phone();
        phone.setId(row.getLong("id"));
        phone.setName(row.getString("name"));
        phone.setBrand(row.getString("brand"));
        phone.setModel(row.getString("model"));
        phone.setPhoneNumber(row.getString("phone_number"));
        phone.setSerialNumber(row.getString("serial_number"));
        phone.setOs(row.getString("os"));
        phone.setEmail(row.getString("email"));
        phone.setStorageCapacity(row.getInt("storage_capacity"));
        phone.setRamSize(row.getInt("ram_size"));
        phone.set5G(row.getBoolean("is_5g"));
        phone.setPrice(row.getDouble("price"));
        phone.setPurchaseDate(row.getDate("purchase_date"));
        phone.setContactPerson(row.getString("contact_person"));
        phone.setContact(row.getBoolean("contact"));
                

        return phone;
    }

    @Override
    public List<Phone> findAll() {
        List<Phone> phones = new ArrayList<>();
        String sql = "SELECT id, name, brand, model, phone_number, serial_number, os, email, storage_capacity, ram_size, is_5g, price, purchase_date, contact_person, contact FROM phone";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
        while (rows.next()) {
            Phone phone = mapRowToPhone(rows);
            phones.add(phone);
        }
        return phones;
    }

    @Override
    public void update(Phone phone) {
        String sql = "UPDATE phone SET name = ?, brand = ?, model = ?, phone_number = ?, serial_number = ?, os = ?, email = ?, storage_capacity = ?, ram_size = ?, is_5g = ?, price = ?, purchase_date = ?, contact_person = ?, contact = ? WHERE id = ?";
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
            phone.isContact(),
            phone.getId()
        );
        
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM phone WHERE id = ?";
        jdbcTemplate.update(sql, id);
        
    }

    
    
}