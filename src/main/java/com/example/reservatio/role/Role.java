package com.example.reservatio.role;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.example.reservatio.role.Permissions.*;


@AllArgsConstructor
public enum Role {

    ROLE_USER(new LinkedHashSet<>(Arrays.asList(READ, ORDERS, HOTELS, ROOMS, CARS, CHANGE_PASSWORD))),
    ROLE_ADMIN(new LinkedHashSet<>(Arrays.asList(CREATE, DELETE, UPDATE, READ, CARS, ORDERS, HOTELS, ROOMS, CHANGE_PASSWORD, ALL_USER, ALL_ORDERS, CHANGE_PASSWORD))),
    ROLE_SUPER_ADMIN(new LinkedHashSet<>(Arrays.asList(CREATE, DELETE, UPDATE, READ, CARS, ROOMS, USERS, HOTELS, ADMINS, ORDERS, CHANGE_PASSWORD)));

    private final Set<Permissions> pages;


}


