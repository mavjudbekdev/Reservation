package com.example.reservatio.rental;

import com.example.reservatio.car.CarRepository;
import com.example.reservatio.car.dto.CarCreateDto;
import com.example.reservatio.car.entity.Car;
import com.example.reservatio.rental.dto.RentCreateDto;
import com.example.reservatio.rental.entity.Rental;
import com.example.reservatio.user.UserRepository;
import com.example.reservatio.user.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final RentalRepository rentalRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public String create(RentCreateDto rentCreateDto) {


        User user = userRepository.findUserByEmail(rentCreateDto.getEmail()).get();

        if (user.getFirstName() == null && user.getLastName() == null && user.getPhoneNumber() == null && user.getPassportNumber() == null && user.getCardNumber() == null) {
            System.out.println("User malumolari to´liq emas");
            return "rental/full-reg/" + user.getId();
        }


        Car car = carRepository.findById(rentCreateDto.getCarId()).get();
        Rental rent = new Rental(null, user, car, rentCreateDto.getStartDate(), rentCreateDto.getEndDate());
        rentalRepository.save(rent);

        return "";

    }

    @Transactional
    public CarCreateDto getCarById(Integer carId) {
        Car car = carRepository.findById(carId).get();

        CarCreateDto map = modelMapper.map(car, CarCreateDto.class);
        System.out.println(map);
        return map;
    }

    public void deleteByUserRent(Integer rentId) {
        rentalRepository.deleteById(rentId);
    }

    @Transactional
    public List<Rental> getAllRentsByCarlId(Integer carId) {
        Car car = carRepository.findById(carId).orElseThrow();
        List<Rental> rents = car.getRents();
        if (rents == null) {
            return Collections.emptyList();
        }
        return rents;
    }

}
