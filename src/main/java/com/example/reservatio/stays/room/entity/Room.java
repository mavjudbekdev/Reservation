package com.example.reservatio.stays.room.entity;


import com.example.reservatio.book.entity.Book;
import com.example.reservatio.stays.hotel.entity.Hotel;
import com.example.reservatio.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "room")
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer number;
    private Integer roomCount;
    @ManyToOne
    private Hotel hotel;

    @OneToMany(mappedBy = "room")
    private List<Book> books;

}

