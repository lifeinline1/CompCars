package com.cars.CompCars.car;

import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CarService {
    void addCar(Car car);
    Optional<Car> getCarById(Integer id);
    List<Car> getAllCars();
    void deleteCarById(Integer id);
    void updateCar(Integer id, Car car);
}
