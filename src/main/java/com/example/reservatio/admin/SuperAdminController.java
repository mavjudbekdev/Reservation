package com.example.reservatio.admin;

import com.example.reservatio.user.UserService;
import com.example.reservatio.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/superAdmin")
@RequiredArgsConstructor
public class SuperAdminController {

    private final UserService userService;

    @PreAuthorize(value = "hasAnyAuthority('ROLE_SUPER_ADMIN')")
    @GetMapping("/userRole")
    public String getUser(Model model){
        List<User> allUser = userService.getAllUser();
        model.addAttribute("allUser",allUser);
        return "admin/super-admin";
    }
}
