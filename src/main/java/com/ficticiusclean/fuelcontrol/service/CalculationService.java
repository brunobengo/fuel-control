package com.ficticiusclean.fuelcontrol.service;


import com.ficticiusclean.fuelcontrol.dto.CalculationRequestDTO;
import com.ficticiusclean.fuelcontrol.dto.CalculationResponseDTO;

import java.util.List;

public interface CalculationService {

    List<CalculationResponseDTO> getAllCarsCalculated(CalculationRequestDTO calculationRequestDTO);

}
