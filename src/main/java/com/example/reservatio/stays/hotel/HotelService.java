package com.example.reservatio.stays.hotel;

import com.example.reservatio.stays.hotel.address.Region;
import com.example.reservatio.stays.hotel.dto.HotelCreateDto;
import com.example.reservatio.stays.hotel.dto.HotelResponseDto;
import com.example.reservatio.stays.hotel.dto.HotelSearchDto;
import com.example.reservatio.stays.hotel.entity.Hotel;
import com.example.reservatio.stays.room.entity.Room;
import com.example.reservatio.stays.room.repository.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Stream;


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
    public List<HotelResponseDto> getAllHotels(HotelSearchDto hotelSearchDto) {
        String region = hotelSearchDto.getRegion();
        LocalDateTime startDate = hotelSearchDto.getStartDate();
        LocalDateTime endDate = hotelSearchDto.getEndDate();
        Integer roomCount = hotelSearchDto.getRoomCount();


        if (region == null) {
            return Collections.emptyList();
        }

        return checkHotelData(region, startDate, endDate, roomCount);

    }


    @Transactional
    public List<HotelResponseDto> checkHotelData(String region, LocalDateTime startDate, LocalDateTime endDate, Integer roomCount) {
        List<Hotel> all = hotelRepository.findAll();
        ArrayList<Hotel> hotels = new ArrayList<>();
        for (Hotel hotel : all) {
            boolean isRegion = Objects.equals(hotel.getRegion().name(), region);

            if (isRegion){
                for (Room room : hotel.getRooms()) {
                    Integer roomCount1 = room.getRoomCount();

                    if (roomCount1.equals(roomCount)) {
                        hotels.add(hotel);
                        break;
                    }
                }
            }


        }

        return hotels.stream().map(hotelModelMapper::toResponseDto).toList();

    }


    @Transactional
    public HotelResponseDto getById(Integer id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("hotel not found "));
        return hotelModelMapper.toResponseDto(hotel);
    }


    @Transactional
    public List<Room> getRooms(Integer id, Integer roomCount, LocalDateTime startDate, LocalDateTime endDate) {
        return roomRepository.findAvailableRooms(id, roomCount, startDate, endDate);
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
        return roomRepository.findAvailableRooms(id, roomCount, startDate, endDate);
    }

    @Transactional
    public List<Hotel> getHotelForAdmin() {
        return hotelRepository.findAll();
    }


    @Transactional
    public List<Hotel> getFilteredHotels() {
        List<Hotel> filteredHotels = new ArrayList<>();
        List<Hotel> hotels = hotelRepository.findAll();

        for (Hotel hotel : hotels) {
            List<Room> rooms = hotel.getRooms();

            long emptyRoomsCount = rooms.size();

            if (emptyRoomsCount >= 4 && hotel.getRegion() == Region.Tashkent) {
                filteredHotels.add(hotel);
            }
        }

        if (filteredHotels.size() > 6) {
            filteredHotels.subList(0, 6);
        }
        return filteredHotels;
    }

    // todo add exceptions all methods

}

