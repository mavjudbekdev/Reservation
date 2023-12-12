package com.example.reservatio.car;


import com.example.reservatio.car.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    @Query("SELECT c FROM Car c WHERE c.id NOT IN " +
            "(SELECT r.car.id FROM Rental r WHERE " +
            "(r.startDate <= :endDate AND r.endDate >= :startDate) OR " +
            "(r.startDate <= :startDate AND r.endDate >= :endDate))")
    List<Car> findAvailableCars(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
