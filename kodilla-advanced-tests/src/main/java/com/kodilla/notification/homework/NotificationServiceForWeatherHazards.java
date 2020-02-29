package com.kodilla.notification.homework;

import java.util.HashMap;
import java.util.Map;

public class NotificationServiceForWeatherHazards {
    private Map<Client,Locations> clients = new HashMap<>();


    public void addSubscriberToLocations(Client client, Locations locations) {
        this.clients.put(client, locations);


    }
public void removeSubscriberFromLocation(Client client, Locations location){
        this.clients.forEach((client1,location1) -> clients.remove(client,location));
}
    public void sendNotificationToLocations(Notification notification, Locations location) {
        this.clients.forEach((client, locations) -> client.receive(notification,location));

    }
}