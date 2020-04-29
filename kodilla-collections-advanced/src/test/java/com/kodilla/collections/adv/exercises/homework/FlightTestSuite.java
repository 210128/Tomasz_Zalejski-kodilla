package com.kodilla.collections.adv.exercises.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightTestSuite {
    @Test
    public void shouldGetDeparture(){
        //Given
        Flight flight = new Flight("Warsaw", "Berlin");
        //When
        String result = flight.getDeparture();
        //Then
        assertEquals(result, "Warsaw");
    }
    @Test
    public void shouldGetArrival(){
        //Given
        Flight flight = new Flight("Tokyo", "Paris");
        //When
        String result = flight.getArrival();
        //Then
        assertEquals(result, "Paris");
    }

}