package com.example.reservatio.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/test")
public class AuthorizationTestController {

    
    @PreAuthorize("hasAuthority('PERMISSION_USER_CREATE')")
    @GetMapping("/user_create")
    public String userCreate(){
        return "user_create";
    }


    @PreAuthorize("hasAuthority('PERMISSION_USER_UPDATE')")
    @GetMapping("/user_update")
    public String userUpdate(){
        return "user_update";
    }



    @PreAuthorize("hasAuthority('PERMISSION_USER_DELETE')")
    @GetMapping("/user_delete")
    public String userDelete(){
        return "user_delete";
    }



    @PreAuthorize("hasAuthority('PERMISSION_USER_READ')")
    @GetMapping("/user_read")
    public String userRead(){
        return "user_read";
    }



    @PreAuthorize("hasAuthority('PERMISSION_USER_LESSON_START')")
    @GetMapping("/user_lesson_start")
    public String userLessonStart(){
        return "user_lesson_start";
    }


    @PreAuthorize("hasAuthority('PERMISSION_USER_LESSON_END')")
    @GetMapping("/user_lesson_end")
    public String userLessonEnd(){
        return "user_lesson_end";
    }
}
