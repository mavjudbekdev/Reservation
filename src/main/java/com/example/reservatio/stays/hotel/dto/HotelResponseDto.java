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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Region region;
    @OneToMany(mappedBy =  ("hotel"))
    private List<Room> rooms;
}
