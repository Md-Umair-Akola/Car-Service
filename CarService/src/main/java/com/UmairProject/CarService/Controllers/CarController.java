package com.UmairProject.CarService.Controllers;

import com.UmairProject.CarService.Models.Car;
import com.UmairProject.CarService.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public ResponseEntity<Car> postCar(@RequestBody Car car){
        return carService.addCar(car);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllCars(){
        return carService.getAllCars();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCar(@PathVariable int id){
        return carService.deleteCar(id);
    }

    @PatchMapping("/updateCar/{id}")
    public ResponseEntity<Object> updateCar(@RequestBody Optional<Car> car, @PathVariable int id){
            return carService.updateCar(car,id);
    }
}
