package com.example.reservatio.Service.eating.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "eating_place")
public class Eating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private String phoneNumber;
    private String operatingHours;
    @Column(name = "eating_image_url")
    private String eatingImageURL;

}
