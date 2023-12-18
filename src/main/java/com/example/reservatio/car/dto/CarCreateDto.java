package com.example.reservatio.car.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarCreateDto {

    private String name;
    private String description;
    private String number;
    private LocalDate manufacturedDate;
    private Integer dailyPrice;
    @Column(length = 500)
    private String image;
}
