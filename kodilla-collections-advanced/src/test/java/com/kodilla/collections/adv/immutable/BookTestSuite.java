package com.kodilla.collections.adv.immutable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTestSuite {
    @Test
    public void shouldGetAuthor(){
        //Given
        Book book = new Book("Stephen King", "The Shining");
        //When
        String result = book.getAuthor();
        //Then
        assertEquals(result, "Stephen King");
    }
    @Test
    public void shouldGetTitle(){
        //Given
        Book book = new Book("Stephen King", "The Shining");
        //When
        String result = book.getTitle();
        //Then
        assertEquals(result, "The Shining");
    }

}