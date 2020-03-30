package com.kodilla.rest.service;

import com.kodilla.rest.domain.BookDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<BookDto> books = new ArrayList<>();

    public List<BookDto> getBooks() {
        return books;
    }

    public boolean addBook(BookDto bookDto) {
        return books.add(bookDto);
    }

    public boolean removeBook(BookDto bookDto) {
        return books.remove(bookDto);
    }

    public String addBook2(BookDto bookDto) {
        return books.add(bookDto) ? "T" : "F";

    }
}

