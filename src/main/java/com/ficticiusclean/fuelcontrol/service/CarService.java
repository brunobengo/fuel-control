package com.ficticiusclean.fuelcontrol.service;

import com.ficticiusclean.fuelcontrol.dto.CarDTO;
import com.ficticiusclean.fuelcontrol.model.Car;

import java.util.List;
import java.util.UUID;

public interface CarService {

    List<CarDTO> getAllCars();
    Car createCar(Car carDTO);
    CarDTO updateCar(UUID uuid, Car car);
    void deleteCar(UUID uuid);
    CarDTO getCarById(UUID uuid);
}
