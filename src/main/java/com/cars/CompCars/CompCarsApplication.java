package com.cars.CompCars;

import com.cars.CompCars.car.Car;
import com.cars.CompCars.car.CarService;
import com.cars.CompCars.user.User;
import com.cars.CompCars.user.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CompCarsApplication {

	public static void main(String[] args) {


		ConfigurableApplicationContext context = SpringApplication.run(CompCarsApplication.class, args);
		final CarService carService = context.getBean(CarService.class);
		final UserService userService = context.getBean(UserService.class);



		Car car = new Car();
		car.setBrand("BMW");
		car.setModel("M1");
		car.setMakeYear("2020");
		car.setMileage("190000");

		User user = new User();
		user.setName("Sebastian");
		user.setPassword("1234");
		user.setEmail("sebastian@gmail.com");
		user.setPhoneNumber("890098098");

		carService.addCar(car);
		userService.addUser(user);


	}

}
