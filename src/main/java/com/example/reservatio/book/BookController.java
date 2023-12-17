package com.example.reservatio.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @PostMapping
    public String createBook(@ModelAttribute BookCreateDto bookCreateDto){
        bookService.create(bookCreateDto);
        return "redirect:/";
    }
}
