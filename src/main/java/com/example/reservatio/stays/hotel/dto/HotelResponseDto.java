package com.example.reservatio.stays.hotel.dto;

import com.example.reservatio.stays.hotel.address.Region;
import com.example.reservatio.stays.room.entity.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelResponseDto {
    private Integer id;
    private String name;
    private Region region;
    private List<Room> rooms;
    private String image;
}
