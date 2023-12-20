package com.example.reservatio.user;
import com.example.reservatio.car.entity.Car;
import com.example.reservatio.rental.entity.Rental;
import com.example.reservatio.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmail(String email);


}
