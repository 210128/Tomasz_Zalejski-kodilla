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
        NotificationServiceForWeatherHazards weatherNotificationService = new NotificationServiceForWeatherHazards();
        Client client = Mockito.mock(Client.class);
        Client client1 = Mockito.mock(Client.class);
        Location location = new Location("Warsaw");
        Location location1 = new Location("Berlin");
        Location location2 = new Location("Paris");
        //when
        weatherNotificationService.addSubscriberToLocation(client, location);
        weatherNotificationService.addSubscriberToLocation(client, location1);
        weatherNotificationService.addSubscriberToLocation(client1, location2);
        //then
        Assertions.assertTrue(weatherNotificationService.getClientLocation(client).contains(location));
        Assertions.assertTrue(weatherNotificationService.getClientLocation(client).contains(location1));
        Assertions.assertTrue(weatherNotificationService.getClientLocation(client1).contains(location2));

        Assertions.assertFalse(weatherNotificationService.getClientLocation(client).contains(location2));
        Assertions.assertFalse(weatherNotificationService.getClientLocation(client1).contains(location));
        Assertions.assertFalse(weatherNotificationService.getClientLocation(client1).contains(location1));

    }

    @Test
    public void shouldBePossibleToUnsubscribeFromTheLocation() {
        NotificationServiceForWeatherHazards weatherNotificationService = new NotificationServiceForWeatherHazards();
        Client client = Mockito.mock(Client.class);
        Location location = Mockito.mock(Location.class);
        Location location1 = Mockito.mock(Location.class);

        weatherNotificationService.addSubscriberToLocation(client, location);
        weatherNotificationService.addSubscriberToLocation(client, location1);

        Assertions.assertTrue(weatherNotificationService.getClientLocation(client).contains(location));
        Assertions.assertTrue(weatherNotificationService.getClientLocation(client).contains(location1));

        weatherNotificationService.removeSubscriberFromLocation(client, location1);
        Assertions.assertFalse(weatherNotificationService.getClientLocation(client).contains(location1));
    }

    @Test
    public void shouldBePossibleToUnsubscribeFromAllLocations() {
        NotificationServiceForWeatherHazards weatherNotificationService = new NotificationServiceForWeatherHazards();
        Client client = Mockito.mock(Client.class);
        Location location = Mockito.mock(Location.class);
        Location location1 = Mockito.mock(Location.class);

        weatherNotificationService.addSubscriberToLocation(client, location);
        weatherNotificationService.addSubscriberToLocation(client, location1);

        Assertions.assertTrue(weatherNotificationService.getClientLocation(client).contains(location));
        Assertions.assertTrue(weatherNotificationService.getClientLocation(client).contains(location1));

        weatherNotificationService.removeSubscriberFromLocation(client, location1);
        Assertions.assertFalse(weatherNotificationService.getClientLocation(client).contains(location1));
    }

    @Test
    public void notificationForClientInAGivenLocationShouldOnlyReachASpecificGroupOfPeople() {
        NotificationServiceForWeatherHazards weatherNotificationService = new NotificationServiceForWeatherHazards();
        Client client = Mockito.mock(Client.class);
        Client client1 = Mockito.mock(Client.class);
        Notification notification = Mockito.mock(Notification.class);
        Location location = Mockito.mock(Location.class);
        Location location1 = Mockito.mock(Location.class);
        Location location2 = Mockito.mock(Location.class);
        //when
        weatherNotificationService.addSubscriberToLocation(client, location);
        weatherNotificationService.addSubscriberToLocation(client, location1);
        weatherNotificationService.addSubscriberToLocation(client1, location2);
        weatherNotificationService.sendNotificationToLocations(notification, location);
        weatherNotificationService.sendNotificationToLocations(notification, location1);
        weatherNotificationService.sendNotificationToLocations(notification, location2);
        Mockito.verify(client, Mockito.times(1)).receive(notification, location);
        Mockito.verify(client, Mockito.times(1)).receive(notification, location1);
        Mockito.verify(client1, Mockito.times(1)).receive(notification, location2);
    }

    @Test
    public void shouldBePossibleToSendNotificationsToEveryone() {
        NotificationServiceForWeatherHazards weatherNotificationService = new NotificationServiceForWeatherHazards();
        Client client = Mockito.mock(Client.class);
        Client client1 = Mockito.mock(Client.class);
        Client client2 = Mockito.mock(Client.class);
        Location location = Mockito.mock(Location.class);
        Notification notification = Mockito.mock(Notification.class);
        weatherNotificationService.addSubscriberToLocation(client, location);
        weatherNotificationService.addSubscriberToLocation(client1, location);
        weatherNotificationService.addSubscriberToLocation(client2, location);
        weatherNotificationService.sendNotificationToAllClients(notification);
        Mockito.verify(client, Mockito.times(1)).receive(notification);
        Mockito.verify(client1, Mockito.times(1)).receive(notification);
        Mockito.verify(client2, Mockito.times(1)).receive(notification);
    }
}