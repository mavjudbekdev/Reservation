package com.example.reservatio.book;

import com.example.reservatio.book.entity.Book;
import com.example.reservatio.stays.room.entity.Room;
import com.example.reservatio.stays.room.repository.RoomRepository;
import com.example.reservatio.user.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final RoomRepository roomRepository;

    @Transactional
    public void create(BookCreateDto bookCreateDto, User user) {

        Room room = roomRepository.findById(bookCreateDto.getRoomId()).orElseThrow();
        Book book = new Book(null, room, user, bookCreateDto.getStartDate(), bookCreateDto.getEndDate());
        bookRepository.save(book);
    }

    public void deleteBookById(Integer bookId) {
        bookRepository.deleteById(bookId);
    }
}
