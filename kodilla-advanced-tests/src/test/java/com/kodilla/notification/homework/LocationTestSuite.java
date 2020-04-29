package com.kodilla.notification.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTestSuite {
    @Test
    public void shouldGetLocationName(){
        //Given
        Location location = new Location("Berlin");
        //When
        String result = location.getLocationName();
        //Then
        assertEquals(result, "Berlin");
    }

}