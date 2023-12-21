package com.example.reservatio.stays.hotel.dto;

import com.example.reservatio.stays.hotel.address.Region;
import jakarta.persistence.Column;
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
    @Column(length = 500)
    private String image;
    private String phoneNumber;

}
