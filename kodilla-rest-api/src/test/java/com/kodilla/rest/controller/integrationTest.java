package com.kodilla.rest.controller;

import com.kodilla.rest.domain.BookDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Import(Config.class)
@ExtendWith(SpringExtension.class)
public class integrationTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void shouldAddBooks2() throws Exception {
        //given
        Assertions.assertNotNull(restTemplate);
        var bookDto = new BookDto("title 1", "author 1");
        HttpEntity<BookDto> request = new HttpEntity<>(bookDto);
        String bookResourceUrl = "http://localhost:8080/books";
        ResponseEntity<Boolean> response = restTemplate
                .exchange(bookResourceUrl, HttpMethod.POST, request, Boolean.class);

        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody(), true);

    }

   /* @Test
    public void shouldGetBooks2() throws Exception {

        List<BookDto> booksList = new ArrayList<>();
        booksList.add(new BookDto("title 1", "author 1"));
        booksList.add(new BookDto("title 2", "author 2"));
        Assertions.assertNotNull(restTemplate);
        HttpEntity<List<BookDto>> request = new HttpEntity<>(booksList);
        String bookResourceUrl = "http://localhost:8080/books";
        ResponseEntity<BookDto> response = restTemplate
                .exchange(bookResourceUrl, HttpMethod.GET, request, BookDto.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }*/

    @Test
    public void shouldDeleteBook() throws Exception {
        Assertions.assertNotNull(restTemplate);
        List<BookDto> booksList = new ArrayList<>();
        booksList.add(new BookDto("title 1", "author 1"));
        booksList.add(new BookDto("title 2", "author 2"));
        var bookDto = booksList.get(1);
        HttpEntity<BookDto> request = new HttpEntity<>(bookDto);
        String bookResourceUrl = "http://localhost:8080/books";
        ResponseEntity<Boolean> responseAdd = restTemplate
                .exchange(bookResourceUrl, HttpMethod.POST, request, Boolean.class);

     /*   ResponseEntity<List> books = restTemplate
                .exchange(bookResourceUrl, HttpMethod.GET, new HttpEntity(new ArrayList()), List.class);
        assertEquals(books.getStatusCode(), HttpStatus.OK);
        assertThat(books.getBody(), contains(bookDto) );

        ResponseEntity<Boolean> response = restTemplate
                .exchange(bookResourceUrl, HttpMethod.DELETE, request, Boolean.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), true);
*/
    }
}