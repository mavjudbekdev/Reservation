package com.example.reservatio.Service.carService.repository;

import com.example.reservatio.Service.carService.entity.AutoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoServiceRepository extends JpaRepository<AutoService, Integer> {
}
