package com.example.reservatio.user.dto;

import com.example.reservatio.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String getUserInfo() {

        return "user/user-info";
    }

}
