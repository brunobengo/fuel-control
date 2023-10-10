package com.ficticiusclean.fuelcontrol.controller;

import com.ficticiusclean.fuelcontrol.dto.CarDTO;
import com.ficticiusclean.fuelcontrol.model.Car;
import com.ficticiusclean.fuelcontrol.helper.mapper.CarMapper;
import com.ficticiusclean.fuelcontrol.service.CarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping("/api/cars/v1")
@Tag(name="Car", description="CRUD necessário para o controle de frotas")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCars() {
        List<CarDTO> cars = carService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable UUID uuid) {
        CarDTO car = carService.getCarById(uuid);
        if (car != null) {
            return new ResponseEntity<>(car, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody CarDTO carDTO) {
        Car car = carService.createCar(CarMapper.toEntity(carDTO));
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable UUID uuid, @RequestBody CarDTO carDTO) {
        CarDTO carDTOResponse = carService.updateCar(uuid, CarMapper.toEntity(carDTO));
        if (carDTOResponse != null) {
            return new ResponseEntity<>(carDTOResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteCar(@PathVariable UUID uuid) {
        carService.deleteCar(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

