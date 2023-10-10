package com.ficticiusclean.fuelcontrol.service.impl;

import com.ficticiusclean.fuelcontrol.dto.CalculationRequestDTO;
import com.ficticiusclean.fuelcontrol.dto.CalculationResponseDTO;
import com.ficticiusclean.fuelcontrol.model.Car;
import com.ficticiusclean.fuelcontrol.repository.CarRepository;
import com.ficticiusclean.fuelcontrol.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

@Service
public class CalculationServiceImpl implements CalculationService {
    private final CarRepository carRepository;
    private static final Locale LOCALE_BR = new Locale("pt", "BR");

    @Autowired
    public CalculationServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CalculationResponseDTO> getAllCarsCalculated(CalculationRequestDTO calculationRequestDTO) {
        List<Car> cars =  carRepository.findAll();
        List<CalculationResponseDTO> listCalculationResponseDTO = new ArrayList<>();
        cars.forEach(car->
                listCalculationResponseDTO.add(
                        CalculationResponseDTO.builder()
                                .name(car.getName())
                                .brand(car.getBrand())
                                .model(car.getModel())
                                .year(car.getManufacturingDate().getYear())
                                .fuelSpent(roundThree(getFuelSpent(car,  calculationRequestDTO)))
                                .valueSpent(NumberFormat.getCurrencyInstance(LOCALE_BR).format(getFuelPrice(car, calculationRequestDTO)))
                                .build()));
        listCalculationResponseDTO.sort(Comparator.comparing(CalculationResponseDTO::getFuelSpent));
        return listCalculationResponseDTO;
    }

    private double roundThree(double number) {
        return Math.round(number * 1000.0) / 1000.0;
    }

    private double getFuelPrice(Car car, CalculationRequestDTO calculationRequestDTO) {
        return getFuelSpent(car, calculationRequestDTO) * calculationRequestDTO.getFuelPrice();
    }
    private double getFuelSpent(Car car, CalculationRequestDTO calculationDTO) {
        double sumKm = calculationDTO.getKmInHighway() + calculationDTO.getKmInCity();
        return sumKm/car.getAverageFuelConsumptionCity();
    }
}
