package com.filmon.Peniel.Family.Market.models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Entity
@Data 
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Phone {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String brand;
    private String model;
    private String phoneNumber;
    private String serialNumber;
    private String os;
    private String email;
    private int storageCapacity;
    private int ramSize;
    private boolean is5G;
    private double price;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    private Date purchaseDate;
    private String contactPerson;
    private boolean contact;
}
