package com.example.reservatio.Service.carService.repository;

import com.example.reservation.Service.carService.entity.AutoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoServiceRepository extends JpaRepository<AutoService, Integer> {
}
