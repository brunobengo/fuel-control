package com.ficticiusclean.fuelcontrol.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CalculationRequestDTO {
    private double fuelPrice;
    private double kmInCity;
    private double kmInHighway;
}