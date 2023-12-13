package com.example.reservatio.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFullRegisterDto {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String passportNumber;

}
