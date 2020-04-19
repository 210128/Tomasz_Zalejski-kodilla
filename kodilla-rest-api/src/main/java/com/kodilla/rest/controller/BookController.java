package com.kodilla.rest.controller;

import com.kodilla.rest.domain.BookDto;
import com.kodilla.rest.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ArrayList<BookDto> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    public void addBook(@RequestBody BookDto bookDto) {
        bookService.addBook(bookDto);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> removeBook(@RequestBody BookDto bookDto) {

        boolean success = bookService.remove(bookDto);//TODO: Review SINGLE RESPONSIBILITY violation
        // Please encapsulate bookDto removal INSIDE bookService

        var status = (success) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity
                .status(status)
                .body(success);
    }
}

