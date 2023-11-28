package com.example.reservatio.Service.carService.entity;

import jakarta.persistence.*;

@Table(name = "service")
@Entity
public class AutoService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String serviceName;
    private String address;
    private String phoneNumber;
    @Column(name = "service_image_url")
    private String serviceImageURL;

}
