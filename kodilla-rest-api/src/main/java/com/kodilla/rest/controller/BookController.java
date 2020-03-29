package com.kodilla.rest.controller;

import com.kodilla.rest.domain.BookDto;
import com.kodilla.rest.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDto> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    public ResponseEntity<Boolean> addBook(@RequestBody BookDto bookDto) {
        boolean succes = bookService.addBook(bookDto);
        var status = (succes) ?  HttpStatus.CREATED: HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity
                .status(status)
                .body(succes);
    }

    @DeleteMapping
    public void removeBook(@RequestBody BookDto bookDto) {
        bookService.getBooks().remove(bookDto);
    }
}

