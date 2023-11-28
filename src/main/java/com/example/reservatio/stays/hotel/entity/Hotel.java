package com.example.reservatio.stays.hotel.entity;

import com.example.reservation.stays.hotel.address.Region;
import com.example.reservation.stays.room.entity.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hotel")
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @Enumerated(EnumType.STRING)
    private Region region;
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;
}
