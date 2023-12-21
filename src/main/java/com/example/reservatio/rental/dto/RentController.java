package com.example.reservatio.rental.dto;

import com.example.reservatio.car.dto.CarCreateDto;
import com.example.reservatio.rental.RentalService;
import com.example.reservatio.rental.dto.RentCreateDto;
import com.example.reservatio.user.UserService;
import com.example.reservatio.user.dto.UserFullRegisterDto;
import com.example.reservatio.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Controller
@RequestMapping("/rental")
@RequiredArgsConstructor
public class RentController {

    private final RentalService rentalService;
    private final UserService userService;


    @DeleteMapping("/deleteByUserRent")
    public String deleteByUserRent(@RequestParam("rentId") Integer rentId){
        rentalService.deleteByUserRent(rentId);
        return"redirect:/";
    }

    @PostMapping("/rent")
    public String createRent(@ModelAttribute RentCreateDto rentCreateDto, Model model) {

        String s = rentalService.create(rentCreateDto);

        if(!s.isEmpty()){

            return "redirect:/rental/full-reg";

        }

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


    @PostMapping("/full-reg")
    public String fullRegistration(@ModelAttribute UserFullRegisterDto fullRegisterDto) {
        User user = userService.currentUser();
        userService.fullRegister(fullRegisterDto,user.getId());

        return "success";
    }


    @GetMapping("/full-reg")
    public String fullRegPage() {

        return "car/full-reg";
    }

}


