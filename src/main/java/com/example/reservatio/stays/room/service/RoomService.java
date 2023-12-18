package com.example.reservatio.stays.room.service;

import com.example.reservatio.stays.hotel.entity.Hotel;
import com.example.reservatio.stays.hotel.HotelRepository;
import com.example.reservatio.stays.room.RoomCreateDto;
import com.example.reservatio.stays.room.RoomModelMapper;
import com.example.reservatio.stays.room.entity.Room;
import com.example.reservatio.stays.room.repository.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    private final HotelRepository hotelRepository;

    private final RoomModelMapper roomModelMapper;

    @Transactional
    public void create(RoomCreateDto roomCreateDto) {
        Room room = roomModelMapper.toEntity(roomCreateDto);
        Hotel hotel = hotelRepository.findById(roomCreateDto.getHotelId())
                .orElseThrow(() -> new NoSuchElementException("Hotel is already exist"));

        room.setHotel(hotel);
        roomRepository.save(room);
    }

    @Transactional
    public Integer delete(Integer id) {
        Integer hotelId = roomRepository.findById(id)
                .orElseThrow()
                .getHotel().getId();
        roomRepository.deleteById(id);
        return hotelId;
    }
}
