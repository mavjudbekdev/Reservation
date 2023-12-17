package com.example.reservatio.stays.hotel;

import com.example.reservatio.stays.hotel.HotelService;
import com.example.reservatio.stays.hotel.dto.HotelCreateDto;
import com.example.reservatio.stays.hotel.dto.HotelResponseDto;
import com.example.reservatio.stays.room.entity.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/hotel-all")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @GetMapping
    public String getAllHotel(Model model){
       List<HotelResponseDto> hotelResponseDto = hotelService.getAllHotels();
       model.addAttribute("hotels",hotelResponseDto);
       return "index";
    }


    @GetMapping("/{id}/rooms")
    public String getHotelRooms(@PathVariable Integer id,
                                @RequestParam Integer roomCount, Model model,
                                @RequestParam LocalDateTime startDate,
                                @RequestParam LocalDateTime endDate){
        List<Room> rooms = hotelService.getRooms(id, roomCount, startDate, endDate);
        model.addAttribute("rooms",rooms);
        return "room/rooms";
    }

    @GetMapping("/rooms")
    public String getHotelsPage(){
        return "room/rooms";
    }




}
