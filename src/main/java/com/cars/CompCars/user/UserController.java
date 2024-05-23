package com.cars.CompCars.user;

import com.cars.CompCars.car.Car;
import com.cars.CompCars.car.CarRepository;
import com.cars.CompCars.car.CarService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<List<UserDto>> getAllUsers() {
        //todo add message no users
        List<User> users = userService.getAllUsers();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = new UserDto();
            userDto.mapToUserDto(user);
            userDtos.add(userDto);
        }
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer id) {
        //todo add message for not found
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            UserDto userDto = new UserDto();
            userDto.mapToUserDto(user.get());
            return ResponseEntity.ok(userDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/add")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        //todo add exception for invalid data
        userService.addUser(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping(path = "/{id}/assign/{carId}")
    public ResponseEntity<User> addCarToUser(@PathVariable Integer id, @PathVariable Integer carId) {
        Optional<User> user = userService.getUserById(id);
        Optional<Car> car = carService.getCarById(carId);
        if (user.isPresent() && car.isPresent()) {
            user.get().setCar(car.get());
            userService.updateUser(id, user.get());
            return ResponseEntity.ok(user.get());
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        //todo add validation for user not found
        //todo delete Car without User
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted with id: " + id);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @Valid @RequestBody User user) {
        userService.updateUser(id, user);
        return ResponseEntity.ok("User with id: " + id + " updated");
    }



}
