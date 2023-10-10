package com.ficticiusclean.fuelcontrol.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarDTO {

    @JsonIgnore
    private UUID uuid;
    @NotBlank
    @JsonProperty("Nome")
    private String name;
    @NotBlank
    @JsonProperty("Marca")
    private String brand;
    @NotBlank
    @JsonProperty("Modelo")
    private String model;
    @NotBlank
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonProperty("DataDeFabricacao")
    private LocalDate manufacturingDate;
    @NotBlank
    @JsonProperty("ConsumoMedioCidade")
    private double averageFuelConsumptionCity;
    @NotBlank
    @JsonProperty("ConsumoMedioRodovia")
    private double averageFuelConsumptionHighway;
}
