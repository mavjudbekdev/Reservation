package com.example.reservatio.car;

import com.example.reservatio.car.entity.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/car-home")
    public String getCarPage(){
        return "car/car-home";
    }

    @GetMapping("/get-all-car")
    public String getCars(
            @RequestParam(value = "startDate", required = false) LocalDate startDate,
            @RequestParam(value = "endDate", required = false) LocalDate endDate,
            Model model
    )

    {
        List<Car> cars = carService.findAvailableCars(startDate, endDate);
        model.addAttribute("cars", cars);
        return "car/car-home";
    }

}
