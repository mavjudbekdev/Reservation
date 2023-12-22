package com.example.reservatio.book;

import com.example.reservatio.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @PostMapping
    public String createBook(@AuthenticationPrincipal User user, @ModelAttribute BookCreateDto bookCreateDto){

        String s = bookService.create(bookCreateDto, user);

        if(!s.isEmpty()){

            return "redirect:/rental/full-reg";
        }

        return "redirect:/auth/books";
    }

    @GetMapping("/deleteByBook")
    public String deleteBookById(@RequestParam("bookId") Integer bookId) {
        bookService.deleteBookById(bookId);
        return "redirect:/auth/books";
    }
}
