package com.kodilla.rest.service;

import com.kodilla.rest.controller.BookDtoList;
import com.kodilla.rest.domain.BookDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private BookDtoList books = new BookDtoList();

    public BookDtoList getBooks() {
        return books;
    }

    public boolean addBook(BookDto bookDto) {
        return books.add(bookDto);
    }

    public String addBook2(BookDto bookDto) {
        return books.add(bookDto) ? "T" : "F";

    }

    public boolean remove(BookDto bookDto) {
        return books.remove(bookDto);
    }
}

