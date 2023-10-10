package com.ficticiusclean.fuelcontrol.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car")
@Builder
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "uuid", updatable = false, nullable = false)
    @ColumnDefault("random_uuid()")
    private UUID uuid;
    private String name;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private double averageFuelConsumptionCity;
    private double averageFuelConsumptionHighway;

    public Car(String name, String brand, String model, LocalDate manufacturingDate, double averageFuelConsumptionCity, double averageFuelConsumptionHighway){
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.averageFuelConsumptionCity = averageFuelConsumptionCity;
        this.averageFuelConsumptionHighway = averageFuelConsumptionHighway;
    }
}
