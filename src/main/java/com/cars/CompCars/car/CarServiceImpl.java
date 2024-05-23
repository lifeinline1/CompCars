package com.cars.CompCars.car;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public Optional<Car> getCarById(Integer id) {
        Car car = carRepository.findById(id).orElse(null);
        return Optional.ofNullable(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public void deleteCarById(Integer id) {
        carRepository.deleteById(id);
    }

    @Override
    public void updateCar(Integer id, Car car) {
        Car carToUpdate = carRepository.findById(id).orElse(null);
        carToUpdate.setBrand(car.getBrand());
        carToUpdate.setModel(car.getModel());
        carToUpdate.setMileage(car.getMileage());
        carToUpdate.setMakeYear(car.getMakeYear());
        carRepository.save(carToUpdate);
    }
}
