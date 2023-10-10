package com.ficticiusclean.fuelcontrol.service.impl;

import com.ficticiusclean.fuelcontrol.dto.CarDTO;
import com.ficticiusclean.fuelcontrol.exception.CarNotExistException;
import com.ficticiusclean.fuelcontrol.helper.mapper.CarMapper;
import com.ficticiusclean.fuelcontrol.model.Car;
import com.ficticiusclean.fuelcontrol.repository.CarRepository;
import com.ficticiusclean.fuelcontrol.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarDTO> getAllCars() {
        return CarMapper.listCarToDto(carRepository.findAll());
    }

    @Override
    public CarDTO getCarById(UUID uuid) {
        return CarMapper.toDto(carRepository.findById(uuid).orElse(null));
    }

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public CarDTO updateCar(UUID uuid, Car updatedCar) {
        Car existingCar = carRepository.findById(uuid).orElse(null);
        if (existingCar != null) {
            existingCar.setName(updatedCar.getName());
            existingCar.setBrand(updatedCar.getBrand());
            existingCar.setModel(updatedCar.getModel());
            existingCar.setManufacturingDate(updatedCar.getManufacturingDate());
            existingCar.setAverageFuelConsumptionCity(updatedCar.getAverageFuelConsumptionCity());
            existingCar.setAverageFuelConsumptionHighway(updatedCar.getAverageFuelConsumptionHighway());
            return CarMapper.toDto(carRepository.save(existingCar));
        }
        throw new CarNotExistException(uuid);
    }

    public void deleteCar(UUID uuid) {
        carRepository.deleteById(uuid);
    }
}
