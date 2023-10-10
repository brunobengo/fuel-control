package com.ficticiusclean.fuelcontrol.controller;


import com.ficticiusclean.fuelcontrol.dto.CalculationRequestDTO;
import com.ficticiusclean.fuelcontrol.dto.CalculationResponseDTO;
import com.ficticiusclean.fuelcontrol.service.CalculationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/calculation/v1")
@Tag(name="Cálculo", description="Cálculo da previsão de gastos com o combustível")
public class CalculationController {
    private final CalculationService calculationService;

    @Autowired
    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping
    public ResponseEntity<List<CalculationResponseDTO>> getAllCarsCalculated(@RequestBody CalculationRequestDTO calculationRequestDTO) {
        List<CalculationResponseDTO> listCalculationDTO = calculationService.getAllCarsCalculated(calculationRequestDTO);
        return new ResponseEntity<>(listCalculationDTO, HttpStatus.OK);
    }
}
