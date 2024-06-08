package com.UmairProject.CarService.Repositories;

import com.UmairProject.CarService.Models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Car,Integer> {

}
