package com.kodilla.rest.controller;

import com.kodilla.rest.domain.BookDto;
import com.kodilla.rest.service.BookService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BookControllerTest {
    @Test
    public void shouldAddBook() {
        //given
        BookService bookServiceMock = Mockito.mock(BookService.class);
        BookController bookController = new BookController(bookServiceMock);
        BookDto bookDto = Mockito.mock(BookDto.class);
        BookDto bookDto1 = Mockito.mock(BookDto.class);
        bookServiceMock.addBook(bookDto);
        bookServiceMock.addBook(bookDto1);
        Mockito.verify(bookServiceMock, Mockito.times(1)).addBook(bookDto);
        Mockito.verify(bookServiceMock, Mockito.times(1)).addBook(bookDto1);
    }

    @Test
    public void shouldFetchBooks() {
        //given
        BookService bookServiceMock = Mockito.mock(BookService.class);
        BookController bookController = new BookController(bookServiceMock);
        BookDtoList booksList = new BookDtoList();
        booksList.add(new BookDto("Title 1", "Author 1"));
        booksList.add(new BookDto("Title 2", "Author 2"));
        Mockito.when(bookServiceMock.getBooks()).thenReturn(booksList);
        //when
        List<BookDto> result = bookController.getBooks();
        //then
        assertThat(result).hasSize(2);
    }
}