package com.example.reservatio.rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentCreateDto {

    private String email;

    private Integer carId;

    private LocalDate startDate;

    private LocalDate endDate;
}
