package com.example.reservatio.security;

import com.example.reservatio.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "admin/admin";
    }



}
