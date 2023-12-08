package com.example.reservatio.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/per")
public class AdminController {

    @PreAuthorize(value = "hasAuthority('ROLE_USER')")
    @GetMapping("/user_create")
    public String userCreate(){
        return "user_create";
    }



    @PreAuthorize(value = "hasAuthority('ROLE_USER')")
    @GetMapping("/user_update")
    public String userUpdate(){
        return "user_update";
    }



    @PreAuthorize(value = "hasAuthority('ROLE_ADMIN')")
    @GetMapping("/user_delete")
    public String userDelete(){
        return "user_delete";
    }



    @PreAuthorize(value = "hasAuthority('ROLE_SUPER_ADMIN')")
    @GetMapping("/user_read")
    public String userRead(){
        return "user_read";
    }


}
