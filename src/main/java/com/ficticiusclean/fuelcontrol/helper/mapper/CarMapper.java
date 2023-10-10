package com.ficticiusclean.fuelcontrol.helper.mapper;

import com.ficticiusclean.fuelcontrol.dto.CarDTO;
import com.ficticiusclean.fuelcontrol.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
public class CarMapper {
    private CarMapper() {
    }
    public static CarDTO toDto(Car car) {
        if (Objects.isNull(car)) {
            return CarDTO.builder().build();
        }

        return CarDTO.builder()
                .uuid(car.getUuid())
                .name(car.getName())
                .brand(car.getBrand())
                .model(car.getModel())
                .manufacturingDate(car.getManufacturingDate())
                .averageFuelConsumptionCity(car.getAverageFuelConsumptionCity())
                .averageFuelConsumptionHighway(car.getAverageFuelConsumptionHighway())
                .build();
    }

    public static Car toEntity(CarDTO carDTO){
        if (Objects.isNull(carDTO)) {
            return Car.builder().build();
        }
        return Car.builder()
                .name(carDTO.getName())
                .brand(carDTO.getBrand())
                .model(carDTO.getModel())
                .manufacturingDate(carDTO.getManufacturingDate())
                .averageFuelConsumptionCity(carDTO.getAverageFuelConsumptionCity())
                .averageFuelConsumptionHighway(carDTO.getAverageFuelConsumptionHighway())
                .build();
    }

    public static Car toEntityByUUID(UUID uuid) {
        return Car.builder()
                .uuid(uuid)
                .build();
    }


    public static List<CarDTO> listCarToDto(List<Car> listCar) {
        List<CarDTO> listCarDTO = new ArrayList<>();
        for (Car car : listCar) {
            listCarDTO.add(toDto(car));
        }
        return listCarDTO;
    }

}