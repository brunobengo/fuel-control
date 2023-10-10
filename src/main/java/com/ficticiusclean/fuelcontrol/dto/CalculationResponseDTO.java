package com.ficticiusclean.fuelcontrol.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CalculationResponseDTO {
    @JsonProperty("Nome")
    private String name;
    @JsonProperty("Marca")
    private String brand;
    @JsonProperty("Modelo")
    private String model;
    @JsonProperty("Ano")
    private int year;
    @JsonProperty("CombustivelGasto")
    private double fuelSpent;
    @JsonProperty("ValorGasto")
    private String valueSpent;
}