package com.kodilla.notification.homework;


import org.junit.jupiter.api.Assertions;
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
        NotificationServiceForWeatherHazards wheatherNotificationService = new NotificationServiceForWeatherHazards();
        Client client = /*new Client("Tom"); */Mockito.mock(Client.class);
        Client client1 = /*new Client("Mark");*/Mockito.mock(Client.class);
        Location location = new Location("Warsaw");
        Location location1 = new Location("Berlin");
        Location location2 = new Location("Paris");
        //when
        wheatherNotificationService.addSubscriberToLocation(client, location);
        wheatherNotificationService.addSubscriberToLocation(client, location1);
        wheatherNotificationService.addSubscriberToLocation(client1, location2);

        Assertions.assertTrue(wheatherNotificationService.getClientLocation(client).contains(location));
        Assertions.assertTrue(wheatherNotificationService.getClientLocation(client).contains(location1));
        Assertions.assertTrue(wheatherNotificationService.getClientLocation(client1).contains(location2));
        Assertions.assertFalse(wheatherNotificationService.getClientLocation(client).contains(location2));
        Assertions.assertFalse(wheatherNotificationService.getClientLocation(client1).contains(location));
        Assertions.assertFalse(wheatherNotificationService.getClientLocation(client1).contains(location1));

    }

    @Test
    public void shouldBePossibleToUnsubscribeFromTheLocation() {
        NotificationServiceForWeatherHazards wheatherNotificationService = new NotificationServiceForWeatherHazards();
        Client client = Mockito.mock(Client.class);
        Location location = Mockito.mock(Location.class);
        Location location1 = Mockito.mock(Location.class);
        wheatherNotificationService.addSubscriberToLocation(client, location);
        wheatherNotificationService.addSubscriberToLocation(client, location1);
        wheatherNotificationService.removeSubscriberFromLocation(client, location1);
        Notification notification = Mockito.mock(Notification.class);
        wheatherNotificationService.sendNotificationToLocations(notification, location);
        wheatherNotificationService.sendNotificationToLocations(notification, location1);


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