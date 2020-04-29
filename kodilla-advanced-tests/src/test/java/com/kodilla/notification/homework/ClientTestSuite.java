package com.kodilla.notification.homework;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientTestSuite {

    @Test
   public void ShouldGetUsername() {
        //Given
        Client client = new Client("Johny Bravo");
        //When
        String result = client.getUsername();
        //Then
        assertEquals(result, "Johny Bravo");
    }
    @Test
    public void shouldReceiveNotification(){
        //Given
        Client client = Mockito.mock(Client.class);
        Notification notification = new Notification("Hello");
        //When
        client.receive(notification);
        //Then
        Mockito.verify(client).receive(notification);
    }
    @Test
    public void shouldReceiveNotificationWithLocation(){
        //Given
        Client client = Mockito.mock(Client.class);
        Notification notification = new Notification("Hello");
        Location location = new Location("Berlin");
        //When
        client.receive(notification, location);
        //Then
        Mockito.verify(client).receive(notification, location);
    }


}