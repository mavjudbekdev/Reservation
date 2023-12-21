package com.example.reservatio.admin;

import com.example.reservatio.book.BookService;
import com.example.reservatio.car.CarService;
import com.example.reservatio.car.entity.Car;
import com.example.reservatio.rental.RentalService;
import com.example.reservatio.rental.entity.Rental;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hotelEndCar")
@RequiredArgsConstructor
public class HotelAndCarAdminController {


    private final RentalService rentalService;
    private final CarService carService;
    private final BookService bookService;

    // todo cars

    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    @GetMapping("/carsRent")
    public String getCarsRent(@RequestParam(value = "carId") Integer carId, Model model ) {
        List<Rental> rentals = rentalService.getAllRentsByCarlId(carId);
        model.addAttribute("rentals", rentals);
        return "car/carsRent";
    }

    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    @DeleteMapping("/deleteCar")
    public String deleteByCarId(@RequestParam(value = "carId") Integer carId){
        carService.deleteByCarId(carId);
        return "redirect:/super/cars";
    }

    // todo hotels


}
