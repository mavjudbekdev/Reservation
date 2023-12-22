package com.example.reservatio.stays.hotel;

import com.example.reservatio.stays.hotel.entity.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
@Controller
@RequiredArgsConstructor
public class TestController {

    private final HotelService hotelService;


    @GetMapping("/")
    public String getFilteredHotels(Model model) {
        List<Hotel> filteredHotels = hotelService.getFilteredHotels();
        model.addAttribute("filteredHotels", filteredHotels);
        return "index";
    }

}
