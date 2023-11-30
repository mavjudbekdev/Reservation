package com.example.reservatio.stays.hotel;

import com.example.reservatio.stays.hotel.dto.HotelCreateDto;
import com.example.reservatio.stays.hotel.dto.HotelResponseDto;
import com.example.reservatio.stays.hotel.entity.Hotel;
import com.example.reservatio.stays.hotel.repository.HotelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@Transactional
@RequiredArgsConstructor
public class HotelService {

    private final HotelModelMapper hotelModelMapper;
    private final HotelRepository hotelRepository;

    public void create(HotelCreateDto hotelCreateDto) {
        Hotel hotel = hotelModelMapper.toEntity(hotelCreateDto);
        hotelRepository.save(hotel);
    }

    public List<HotelResponseDto> getAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels
                .stream()
                .map(hotelModelMapper::toResponseDto)
                .toList();
    }

    public HotelResponseDto getById(Integer id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow( () -> new NoSuchElementException("hotel not found "));
        return hotelModelMapper.toResponseDto(hotel);
    }


}

