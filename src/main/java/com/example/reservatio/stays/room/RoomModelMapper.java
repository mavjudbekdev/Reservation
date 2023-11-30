package com.example.reservatio.stays.room;

import com.example.reservatio.stays.room.entity.Room;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomModelMapper {

    private final ModelMapper modelMapper;

    public Room toEntity(RoomCreateDto roomCreateDto){
        return modelMapper.map(roomCreateDto,Room.class);
    }

}
