package com.kodilla.notification.homework;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NotificationServiceForWeatherHazardsTestSuite {

    @Test
    public void notSubscribedClientShouldNotReceiveNotification() {
       NotificationServiceForWeatherHazards notificationService = new NotificationServiceForWeatherHazards();
        Client client = Mockito.mock(Client.class);
        Location location= Mockito.mock(Location.class);
        Notification notification = Mockito.mock(Notification.class);


    }



    @Test
    public void clientShouldBeAbleToAssignSubscriptionsToAGivenLocationAndStartReceivingNotifications() {
        NotificationServiceForWeatherHazards whetherNotificationService = new NotificationServiceForWeatherHazards();
        Client client = Mockito.mock(Client.class);
        Location location = Mockito.mock(Location.class);
        Location location1 = Mockito.mock(Location.class);
        whetherNotificationService.addSubscriberToLocations(client, location);
        whetherNotificationService.addSubscriberToLocations(client, location1);
        Notification notification = Mockito.mock(Notification.class);
        whetherNotificationService.sendNotificationToLocations(notification, location);
        whetherNotificationService.sendNotificationToLocations(notification,location1);



    }

    @Test
    public void shouldBePossibleToUnsubscribeFromTheLocation() {
        NotificationServiceForWeatherHazards whetherNotificationService = new NotificationServiceForWeatherHazards();
        Client client = Mockito.mock(Client.class);
        Location location = Mockito.mock(Location.class);
        Location location1 = Mockito.mock(Location.class);
        whetherNotificationService.addSubscriberToLocations(client, location);
        whetherNotificationService.addSubscriberToLocations(client, location1);
        whetherNotificationService.removeSubscriberFromLocation(client, location1);
        Notification notification = Mockito.mock(Notification.class);
        whetherNotificationService.sendNotificationToLocations(notification,  location);
        whetherNotificationService.sendNotificationToLocations(notification,location1);


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