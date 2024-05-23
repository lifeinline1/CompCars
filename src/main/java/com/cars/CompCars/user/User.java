package com.cars.CompCars.user;

import com.cars.CompCars.car.Car;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.springframework.validation.annotation.Validated;

@Entity(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotNull
    private String password;
    @NotBlank
    private String phoneNumber;

    @ManyToOne
    private Car car;


}
