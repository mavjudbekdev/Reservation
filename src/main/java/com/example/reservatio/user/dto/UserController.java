package com.example.reservatio.user.dto;

import com.example.reservatio.book.BookService;
import com.example.reservatio.book.entity.Book;
import com.example.reservatio.rental.entity.Rental;
import com.example.reservatio.user.UserService;
import com.example.reservatio.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final BookService bookService;
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


    @GetMapping("/books")
    public String getUserBooks(@AuthenticationPrincipal User user, Model model){
        List<Book> userBooks = userService.getUserBooksByUserId(user.getId());
        model.addAttribute("userBooks",userBooks);
        return "user/user-books";
    }





    @GetMapping("/rents")
    public String getUserRent(@AuthenticationPrincipal User user, Model model){
        List<Rental> userRents = userService.getUserRentsByUserId(user.getId());
        model.addAttribute("userRents" , userRents);
        return "user/user-rents";
    }

    @GetMapping("/user-info")
    public String userAlData(Model model){
        User user = userService.userInfo();
        model.addAttribute("userDetails",user);
        return "user/user-info";
    }




    @GetMapping("/rented-cars")
    public String getUserRentedCarsPage(){
        return "user/rented-cars";
    }

}
