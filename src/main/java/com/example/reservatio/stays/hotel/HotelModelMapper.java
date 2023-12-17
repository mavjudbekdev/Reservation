package com.example.reservatio.stays.hotel;

import com.example.reservatio.stays.hotel.dto.HotelCreateDto;
import com.example.reservatio.stays.hotel.dto.HotelResponseDto;
import com.example.reservatio.stays.hotel.entity.Hotel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HotelModelMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public HotelResponseDto toResponseDto(Hotel hotel) {
        return modelMapper.map(hotel,HotelResponseDto.class);
    }

    public Hotel toEntity(HotelCreateDto hotelCreateDto){
        return modelMapper.map(hotelCreateDto,Hotel.class);
    }

    public HotelResponseDto toResponseDtoAdmin(Hotel hotel) {
        return modelMapper.map(hotel,HotelResponseDto.class);
    }

}

