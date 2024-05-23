package com.cars.CompCars.user;

import com.cars.CompCars.car.Car;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDto {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private Car car;

    public void mapToUserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.phoneNumber = user.getPhoneNumber();
        this.car = user.getCar();
    }
}
