package com.example.reservatio.stays.hotel.dto;

import com.example.reservatio.stays.hotel.address.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelCreateDto {
    private Region region;
    private String name;

}
