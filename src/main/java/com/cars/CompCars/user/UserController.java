package com.cars.CompCars.user;

import com.cars.CompCars.car.Car;
import com.cars.CompCars.car.CarRepository;
import com.cars.CompCars.car.CarService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final CarService carService;

    public UserController(UserService userService, CarService carService) {
        this.userService = userService;
        this.carService = carService;
    }

    //todo add UserDTO class!

    @GetMapping(path = "/all")
    public ResponseEntity<List<User>> getAllUsers() {
        //todo add message no users
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        //todo add message for not found
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/add")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        //todo add exception for invalid data
        userService.addUser(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id) {
        //todo add validation for user not found
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Integer> updateUser(@PathVariable Integer id, @Valid @RequestBody User user) {
        userService.updateUser(id, user);
        return ResponseEntity.ok(id);
    }



}
