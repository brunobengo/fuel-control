package com.ficticiusclean.fuelcontrol.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ficticiusclean.fuelcontrol.model.Car;

import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {
}

