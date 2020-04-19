package com.kodilla.rest.controller;

import com.google.gson.Gson;
import com.kodilla.rest.domain.BookDto;
import com.kodilla.rest.service.BookService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doAnswer;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookController.class)
public class BookControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void shouldFetchBooks() throws Exception {
        //given
        BookDtoList booksList = new BookDtoList();
        booksList.add(new BookDto("title 1", "author 1"));
        booksList.add(new BookDto("title 2", "author 2"));
        Mockito.when(bookService.getBooks()).thenReturn(booksList);
        //when & then
        mockMvc.perform(MockMvcRequestBuilders.get("/books").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
    }

    @Test
    public void shouldAddBook() throws Exception {
        //given
        BookDto bookDto = new BookDto("title 1", "author 1");
        String json = new Gson().toJson(bookDto);
/*
        doAnswer(invocation -> {
            var arg0 = invocation.getArgument(0);

            assertEquals(bookDto, arg0);
            return null;
        }).when(bookService).addBook(bookDto);
*/
        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().is(200))//returned status is OK
                .andExpect(MockMvcResultMatchers.content().string(""));//with empty content
    }
}
