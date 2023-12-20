package com.example.reservatio.rental.entity;

import com.example.reservatio.car.entity.Car;
import com.example.reservatio.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rental")
@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Car car;

    private LocalDate startDate;

    private LocalDate endDate;
}
