package com.example.reservatio.car;

import com.example.reservatio.car.dto.CarCreateDto;
import com.example.reservatio.car.entity.Car;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    @Transactional
    public void create(CarCreateDto carCreateDto) {
        Car car = modelMapper.map(carCreateDto, Car.class);
        carRepository.save(car);
    }

    @Transactional
    public List<Car> findAvailableCars(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null || endDate.isBefore(startDate)){
            return Collections.emptyList();
        }
        return carRepository.findAvailableCars(startDate, endDate);
    }

    @Transactional
    public List<Car> getCarsForAdmin() {
        return carRepository.findAll();
    }


    @Transactional
    public void deleteByCarId(Integer carId) {
        carRepository.deleteById(carId);
    }
}
