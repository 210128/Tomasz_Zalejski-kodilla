package com.kodilla.notification.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationTestSuite {
    @Test
    public void shouldGetAlert(){
        //Given
        Notification notification = new Notification("Storm!!!");
        //When
        String result = notification.getAlert();
        //Then
        assertEquals(result, "Storm!!!");
    }

}