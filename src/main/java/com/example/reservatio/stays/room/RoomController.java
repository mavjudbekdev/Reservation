package com.example.reservatio.stays.room;

import com.example.reservatio.stays.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public String roomCreate(@ModelAttribute RoomCreateDto roomCreateDto) {
        roomService.create(roomCreateDto);
        return "redirect:/hotel/%id/update";
    }

    @DeleteMapping("/{id}")
    public String deleteRoom(@PathVariable Integer id) {
        Integer hotelId = roomService.delete(id);
        return "redirect:/hotel/%d/update".formatted(hotelId);
    }
}
