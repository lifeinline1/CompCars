package com.cars.CompCars.user;


import com.cars.CompCars.car.Car;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void addUser(User user);
    Optional<User> getUserById(Integer id);
    List<User> getAllUsers();
    void deleteUser(Integer id);
    void updateUser(Integer id, User user);


}
