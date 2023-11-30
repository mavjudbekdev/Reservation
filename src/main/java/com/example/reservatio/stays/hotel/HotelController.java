package com.example.reservatio.stays.hotel;

import com.example.reservatio.stays.hotel.dto.HotelCreateDto;
import com.example.reservatio.stays.hotel.dto.HotelResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping
    public String createHotel(@ModelAttribute HotelCreateDto hotelCreateDto){
        hotelService.create(hotelCreateDto);

        return "/";
    }

    @GetMapping
    public String getAllHotel(Model model){
       List<HotelResponseDto> hotelResponseDto = hotelService.getAllHotels();
       model.addAttribute("hotel",hotelResponseDto);
       return "/";
    }

    // hotel create

    @GetMapping("/create")
    public String hotelCreatePage(){
        return "/hotel/create";
    }

    @GetMapping("/{id}/rooms")
    public String getHotelRooms(@PathVariable Integer id){
        return "/";
    }

    @GetMapping("/{id}/update")
    public String getEditHotel(@PathVariable Integer id, Model model ){
        HotelResponseDto byId = hotelService.getById(id);
        model.addAttribute("hotel",byId);
        return "hotel/update";
    }


}
