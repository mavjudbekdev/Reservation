package com.example.reservatio.role;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.example.reservatio.role.Permissions.*;


@AllArgsConstructor
public enum Role {

    ROLE_ADMIN(new LinkedHashSet<>(Arrays.asList(CREATE, DELETE, UPDATE, READ, USERS))),
    ROLE_USER(new LinkedHashSet<>(Arrays.asList(UPDATE, READ, ORDERS, CHANGE_PASSWORD,ALL_USER,ALL_ORDERS,CHANGE_PASSWORD))),
    ROLE_SUPER_ADMIN(new LinkedHashSet<>(Arrays.asList(CREATE, DELETE, UPDATE, READ, USERS, HOTELS, ADMINS, ORDERS, CHANGE_PASSWORD)));

    private final Set<Permissions> pages;

}


