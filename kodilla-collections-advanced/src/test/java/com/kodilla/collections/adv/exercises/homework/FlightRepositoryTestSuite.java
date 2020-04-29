package com.kodilla.collections.adv.exercises.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightRepositoryTestSuite {
    @Test
    public void testGetFlightsTable() {
        //Given
        FlightRepository flightRepository = new FlightRepository();
        //When
        flightRepository.getFlightsTable();
        //Then
        assertEquals(6, flightRepository.size());
    }
}