package com.UmairProject.CarService.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String model;
    int manufacturedYear;
    String companyName;
    String bodyType;
    long price;
    String fuelType;
    int capacity;
}
