package com.example.reservatio.admin;

import com.example.reservatio.car.CarService;
import com.example.reservatio.car.dto.CarCreateDto;
import com.example.reservatio.stays.hotel.HotelService;
import com.example.reservatio.stays.hotel.dto.HotelCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/super")
@RequiredArgsConstructor
public class AdminController {

    private final HotelService hotelService;
    private final CarService carService;




    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    @GetMapping("/create-car")
    public String createCarPage() {
        return "car/car-create";
    }


    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    @PostMapping("/create-car")
    public String createCar(@ModelAttribute CarCreateDto carCreateDto) {
        carService.create(carCreateDto);
        return "success";
    }

    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    @GetMapping("/car-success")
    public String successCarPage() {
        return "success";
    }

    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    @PostMapping("/hotel-create")
    public String createHotel(@ModelAttribute HotelCreateDto hotelCreateDto) {
        hotelService.create(hotelCreateDto);
        return "success";
    }
}
