package com.UmairProject.CarService.Services;

import com.UmairProject.CarService.Models.Car;
import com.UmairProject.CarService.Repositories.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

        @Autowired
        private CarRepo carRepo;

        public ResponseEntity<Car> addCar(Car car){
            try{
                Car save = carRepo.save(car);
                return new ResponseEntity<>(save,HttpStatus.CREATED);
            }catch(Exception e){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }

        public ResponseEntity<Object> getAllCars(){
            List<Car> cars = carRepo.findAll();
            if(cars.isEmpty()){
                return new ResponseEntity<>("No data available",HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(cars,HttpStatus.OK);
        }


        public ResponseEntity<Object> deleteCar(int id){
            try{
                Car car = carRepo.findById(id).orElseThrow(() -> new RuntimeException());
                carRepo.deleteById(id);
                return ResponseEntity.status(HttpStatus.OK).build();
            }catch (Exception e){
                return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
            }
        }

        public ResponseEntity<Object> updateCar(Optional<Car> car, int id){
            if(car.isPresent() && !car.isEmpty()){
                try{
                    Car carToUpdate = carRepo.findById(id).orElseThrow(() -> new RuntimeException());
                    carToUpdate.setPrice(car.get().getPrice());
                    carRepo.save(carToUpdate);
                    return new ResponseEntity<>(carToUpdate,HttpStatus.OK);
                }catch (Exception e){
                    return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
                }
            }
            return new ResponseEntity<>("No Data Provided", HttpStatus.BAD_REQUEST);
        }
}
