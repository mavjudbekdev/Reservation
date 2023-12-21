package com.example.reservatio.stays.hotel.entity;

import com.example.reservatio.stays.hotel.address.Region;
import com.example.reservatio.stays.room.entity.Room;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hotel")
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @Column(unique = true)
    private String phoneNumber;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Enumerated(EnumType.STRING)
    private Region region;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;

    @Column(length = 500)
    private String image;
}
