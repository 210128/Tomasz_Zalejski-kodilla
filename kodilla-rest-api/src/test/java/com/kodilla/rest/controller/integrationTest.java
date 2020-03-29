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
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;


import static org.hamcrest.Matchers.notNullValue;
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
}
