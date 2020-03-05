package com.kodilla.notification.homework;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NotificationServiceForWeatherHazardsTestSuite {

    @Test
    public void notSubscribedClientShouldNotReceiveNotification() {
        NotificationServiceForWeatherHazards notificationService = new NotificationServiceForWeatherHazards();
        Client client = Mockito.mock(Client.class);
        Notification notification = Mockito.mock(Notification.class);

        notificationService.sendNotificationToAllClients(notification);
        Mockito.verify(client, Mockito.never()).receive(notification);
    }


    @Test
    public void clientShouldBeAbleToAssignSubscriptionsToAGivenLocation() {
        //given
        NotificationServiceForWeatherHazards whetherNotificationService = new NotificationServiceForWeatherHazards();
        Client client = new Client("Tom");
        Client client1 = new Client("Mark");
        Location location = new Location("Warsaw");
        Location location1 = new Location("Berlin");
        Location location2 = new Location("Paris");
        //when
        whetherNotificationService.addSubscriberToLocation(client, location);
        whetherNotificationService.addSubscriberToLocation(client, location1);
        whetherNotificationService.addSubscriberToLocation(client1, location2);
       var result = whetherNotificationService.clientLocationsMap.keySet();
        var resultLocations = whetherNotificationService.clientLocationsMap.values().stream().map(Set::toArray);

        assertEquals(new HashSet<>(Arrays.asList(client,client1)), result);
      assertEquals(new HashSet<>(Arrays.asList(location,location1,location2)), resultLocations); //żle


    }

    @Test
    public void shouldBePossibleToUnsubscribeFromTheLocation() {
        NotificationServiceForWeatherHazards whetherNotificationService = new NotificationServiceForWeatherHazards();
        Client client = Mockito.mock(Client.class);
        Location location = Mockito.mock(Location.class);
        Location location1 = Mockito.mock(Location.class);
        whetherNotificationService.addSubscriberToLocation(client, location);
        whetherNotificationService.addSubscriberToLocation(client, location1);
        whetherNotificationService.removeSubscriberFromLocation(client, location1);
        Notification notification = Mockito.mock(Notification.class);
        whetherNotificationService.sendNotificationToLocations(notification, location);
        whetherNotificationService.sendNotificationToLocations(notification, location1);


    }

    @Test
    public void shouldBePossibleToUnsubscribeFromAllLocations() {
        NotificationServiceForWeatherHazards notificationService = new NotificationServiceForWeatherHazards();


    }

    @Test
    public void notificationForClientInAGivenLocationShouldOnlyReachASpecificGroupOfPeople() {
        NotificationServiceForWeatherHazards notificationService = new NotificationServiceForWeatherHazards();

    }

    @Test
    public void shouldBePossibleToSendNotificationsToEveryone() {
        NotificationServiceForWeatherHazards notificationService = new NotificationServiceForWeatherHazards();


    }

    @Test
    public void shouldBePossibleToDeleteTheLocation() {
        NotificationServiceForWeatherHazards notificationService = new NotificationServiceForWeatherHazards();

    }

}//TODO: complete the tests