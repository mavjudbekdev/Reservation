package com.example.reservatio.stays.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelSearchDto {

    private String region;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer roomCount;

}
