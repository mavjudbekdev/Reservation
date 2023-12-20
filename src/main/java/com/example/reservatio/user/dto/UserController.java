package com.example.reservatio.user.dto;

import com.example.reservatio.rental.entity.Rental;
import com.example.reservatio.user.UserService;
import com.example.reservatio.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/sign-in")
    public String getSignIn() {

        return "user/sign-in";
    }

    @GetMapping("/sign-up")
    public String getSignUp() {

        return "user/sign-up";
    }


    @PostMapping("/sign-up")
    public String register(@ModelAttribute UserCreateDto userCreateDto) {
            userService.register(userCreateDto);
        return "redirect:/user/sign-in";
    }



    @GetMapping("/user-info")
    public String userAlData(Model model){
        User user = userService.userInfo();
        model.addAttribute("userDetails",user);
        return "user/user-info";
    }

    @GetMapping("/{userId}/rented-cars")
    public String getUserRentedCars(@PathVariable("userId") Integer userId, Model model) {
        User user = userService.one(userId);
        if (user != null) {
            List<Rental> userRentals = user.getRents();
            model.addAttribute("userRentals", userRentals);
            return "user/rented-cars";
        } else {
            return "user/user-not-found";
        }
    }



    @GetMapping("/rented-cars")
    public String getUserRentedCarsPage(){
        return "user/rented-cars";
    }

}
