package com.example.reservatio.rental;

import com.example.reservatio.car.dto.CarCreateDto;
import com.example.reservatio.rental.dto.RentCreateDto;
import com.example.reservatio.user.UserService;
import com.example.reservatio.user.dto.UserFullRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Controller
@RequestMapping("/rental")
@RequiredArgsConstructor
public class RentController {

    private final RentalService rentalService;
    private final UserService userService;

    @PostMapping("/rent")
    public String createRent(@ModelAttribute RentCreateDto rentCreateDto, Model model) {

        System.out.println(rentCreateDto);

        rentalService.create(rentCreateDto);

        CarCreateDto cars = rentalService.getCarById(rentCreateDto.getCarId());

        model.addAttribute("car", cars);
        model.addAttribute("start", rentCreateDto.getStartDate());
        model.addAttribute("end", rentCreateDto.getEndDate());

        LocalDate startDate = rentCreateDto.getStartDate();
        LocalDate endDate = rentCreateDto.getEndDate();

        long days = ChronoUnit.DAYS.between(startDate, endDate);

        Double overallPrice = (double) (days * cars.getDailyPrice());
        model.addAttribute("overall", overallPrice);

        return "rent/rent-create";
    }

   /* @PostMapping("/full-reg")
    public String fullRegistration(@ModelAttribute UserFullRegisterDto fullRegisterDto){
        userService.fullRegister(fullRegisterDto);
        return "success";
    }*/

}
