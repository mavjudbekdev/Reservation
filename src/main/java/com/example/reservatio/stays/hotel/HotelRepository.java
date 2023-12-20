package com.example.reservatio.stays.hotel;

import com.example.reservatio.stays.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}
