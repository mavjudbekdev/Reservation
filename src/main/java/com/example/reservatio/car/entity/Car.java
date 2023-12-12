package com.example.reservatio.car.entity;
import com.example.reservatio.rental.entity.Rental;
import com.example.reservatio.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 500)
    private String image;

    private String name;

    private String description;

    private String number;

    private LocalDate manufacturedDate;

    private Integer dailyPrice;

    @OneToMany(mappedBy = "car")
    private List<Rental> rents;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
}