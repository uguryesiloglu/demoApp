package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {

        this.carService = carService;
    }

    @PostMapping(value = "/createCar", consumes= MediaType.TEXT_PLAIN_VALUE)
    public String createCar(@RequestBody String carType) {
        Car car = carService.createCar(carType);

        if (car != null)
            return car.getType() + " car has produced";
        else
            return "There is no such car type";

    }
}
