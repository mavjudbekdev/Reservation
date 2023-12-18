package com.example.reservatio.stays.hotel;

import  com.example.reservatio.stays.hotel.dto.HotelCreateDto;
import com.example.reservatio.stays.hotel.dto.HotelResponseDto;
import com.example.reservatio.stays.hotel.entity.Hotel;
import com.example.reservatio.stays.room.entity.Room;
import com.example.reservatio.stays.room.repository.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;


@Service
@Transactional
@RequiredArgsConstructor
public class HotelService {

    private final HotelModelMapper hotelModelMapper;
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;


    @Transactional
    public void create(@ModelAttribute HotelCreateDto hotelCreateDto) throws IOException {

        Hotel hotel = hotelModelMapper.toEntity(hotelCreateDto);
        hotelRepository.save(hotel);
    }


    @Transactional
    public List<HotelResponseDto> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels
                .stream()
                .map(hotelModelMapper::toResponseDto)
                .toList();
    }

    @Transactional
    public HotelResponseDto getById(Integer id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("hotel not found "));
        return hotelModelMapper.toResponseDto(hotel);
    }


    @Transactional
    public List<Room> getRooms(Integer id, Integer roomCount, LocalDateTime startDate, LocalDateTime endDate) {
        return roomRepository.findAvailableRooms(id,roomCount, startDate, endDate);
    }

    @Transactional
    public List<HotelResponseDto> getAllHotelsAdmin() {
        List<Hotel> all = hotelRepository.findAll();
        return all.stream()
                .map(hotelModelMapper::toResponseDtoAdmin)
                .toList();
    }

    @Transactional
    public List<Room> getRoomsAdmin(Integer id, Integer roomCount, LocalDateTime startDate, LocalDateTime endDate) {
        return roomRepository.findAvailableRooms(id,roomCount, startDate, endDate);
    }

    // todo add exceptions all methods

}

