package com.example.reservatio.Service.eating.repository;

import com.example.reservation.Service.eating.entity.Eating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EatingRepository extends JpaRepository<Eating, Integer> {
}
