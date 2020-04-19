package com.kodilla.rest.controller;

import com.kodilla.rest.domain.BookDto;
import java.util.ArrayList;

public class BookDtoList extends ArrayList<BookDto> {

    @Override
    public boolean add(BookDto e){
        return super.add(e);
    }

}
