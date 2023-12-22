package com.example.reservatio.stays.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomCreateDto {
    private Integer number;
    private Integer roomCount;
    private Integer roomDailyPrice;
    private Integer hotelId;
}
