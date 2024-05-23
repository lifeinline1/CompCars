package com.cars.CompCars.car;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars =  carService.getAllCars();
        return ResponseEntity.ok(cars);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Integer id) {
        Car car = carService.getCarById(id).orElseThrow(()-> new RuntimeException("Car not found"));

        return ResponseEntity.ok(car);
    }

    @PostMapping(path = "/add")
    public ResponseEntity addCar(@RequestBody Car car) {
        carService.addCar(car);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteCar(@PathVariable Integer id) {
        carService.deleteCarById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Integer id, @RequestBody Car car) {
        carService.updateCar(id, car);
        return ResponseEntity.ok(car);
    }
}
