package com.cars.CompCars.user;

import com.cars.CompCars.car.Car;
import com.cars.CompCars.car.CarRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CarRepository carRepository;

    public UserServiceImpl(UserRepository userRepository, CarRepository carRepository) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }


    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(Integer id, User user) {
        User userToUpdate = userRepository.findById(id).orElse(null);
        if(userToUpdate != null) {
            userToUpdate.setName(user.getName());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPassword(user.getPassword());
        }

       userRepository.save(userToUpdate);

    }

    @Override
    public void addCarToUser(Integer id, Integer carId) {
        User user = getUserById(id).orElse(null);
        Car car = carRepository.findById(carId).orElse(null);
        if(user != null && car != null) {
            user.setCar(car);
            userRepository.save(user);
        }

    }

}
