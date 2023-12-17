package com.example.reservatio.stays.hotel.dto;

import com.example.reservatio.stays.hotel.address.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelCreateDto {
    private Region region;
    private String name;
    private MultipartFile picture;


}
