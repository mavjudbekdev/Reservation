package com.example.reservatio.admin;

import com.example.reservatio.car.CarService;
import com.example.reservatio.car.dto.CarCreateDto;
import com.example.reservatio.stays.hotel.HotelService;
import com.example.reservatio.stays.hotel.dto.HotelCreateDto;
import com.example.reservatio.stays.hotel.dto.HotelResponseDto;
import com.example.reservatio.stays.room.RoomCreateDto;
import com.example.reservatio.stays.room.entity.Room;
import com.example.reservatio.stays.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequestMapping(value = "/super",method = RequestMethod.POST)
@RequiredArgsConstructor
public class AdminController {

    private final HotelService hotelService;
    private final CarService carService;
    private final RoomService roomService;


    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    @GetMapping("/create-car")
    public String createCarPage() {
        return "car/car-create";
    }


    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    @PostMapping("/create-car")
    public String createCar(@ModelAttribute CarCreateDto carCreateDto) {
        carService.create(carCreateDto);
        return "success";
    }

    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    @GetMapping("/car-success")
    public String successCarPage() {
        return "success";
    }

    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    @PostMapping("/hotel-create")
    public String createHotel(@ModelAttribute HotelCreateDto hotelCreateDto) throws IOException {
        hotelService.create(hotelCreateDto);
        return "success";
    }

    // todo read method !!!


    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    @GetMapping("/hotel-create")
    public String createHotelPage() {
        return "hotels/hotel-create";
    }


    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    @GetMapping
    public String getAllHotels(Model model){
        List<HotelResponseDto> hotels = hotelService.getAllHotelsAdmin();
        model.addAttribute("admin",hotels);
        return "hotels/hotel-get-all";
    }

    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    @GetMapping("/hotel-get-all")
    public String getAllHotelsPage(){
        return "hotels/hotel-get-all";
    }




    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    @PostMapping("(createRoom")
    public String createRoom(@ModelAttribute RoomCreateDto roomCreateDto) {
        roomService.create(roomCreateDto);
        return "redirect:/hotels/%d/hotel-update".formatted(roomCreateDto.getHotelId());
    }

    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteRoom(@PathVariable Integer id) {
        Integer hotelId = roomService.delete(id);
        return "redirect:/hotels/%d/update".formatted(hotelId);
    }


    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    @GetMapping("/{id}/rooms")
    public String getHotelRooms(@PathVariable Integer id,
                                @RequestParam Integer roomCount, Model model,
                                @RequestParam LocalDateTime startDate,
                                @RequestParam LocalDateTime endDate){
        List<Room> room = hotelService.getRoomsAdmin(id, roomCount, startDate, endDate);
        model.addAttribute("room",room);
        return "admin/rooms";
    }

    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    @GetMapping("/rooms")
    public String getHotelsPage(){
        return "admin/rooms";
    }
    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    @GetMapping("/{id}/update")
    public String getEditHotel(@PathVariable Integer id, Model model ){
        HotelResponseDto byId = hotelService.getById(id);
        model.addAttribute("hotel",byId);
        return "hotels/hotel-update";
    }

    @PreAuthorize(value = "hasAnyAuthority('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    @GetMapping("/hotel-update")
    public String getEditHotelPage() {
        return "hotels/hotel-update";
    }



}

