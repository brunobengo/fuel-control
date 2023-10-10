package com.ficticiusclean.fuelcontrol.service.impl;

import com.ficticiusclean.fuelcontrol.dto.CarDTO;
import com.ficticiusclean.fuelcontrol.model.Car;
import com.ficticiusclean.fuelcontrol.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CarServiceImplTest {

    private CarServiceImpl carService;

    @Mock
    private CarRepository carRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        carService = new CarServiceImpl(carRepository);
    }

    @Test
    void testGetAllCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(UUID.randomUUID(), "Car1", "Brand1", "Model1", null, 10.0, 12.0));
        cars.add(new Car(UUID.randomUUID(), "Car2", "Brand2", "Model2", null, 12.0, 14.0));
        when(carRepository.findAll()).thenReturn(cars);

        List<CarDTO> result = carService.getAllCars();

        assertEquals(2, result.size());

        CarDTO car1 = result.get(0);
        assertEquals("Car1", car1.getName());

        CarDTO car2 = result.get(1);
        assertEquals("Car2", car2.getName());
    }

    @Test
    void testGetCarById() {
        UUID uuid = UUID.randomUUID();
        Car car = new Car(uuid, "Car1", "Brand1", "Model1", null, 10.0, 12.0);
        when(carRepository.findById(uuid)).thenReturn(Optional.of(car));

        CarDTO result = carService.getCarById(uuid);

        assertNotNull(result);
        assertEquals(uuid, result.getUuid());
        assertEquals("Car1", result.getName());
    }

}
