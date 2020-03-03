package com.kodilla.notification.homework;

import java.util.*;

public class NotificationServiceForWeatherHazards {
    public final Map<Client, Set<Location>> clientLocationsMap = new HashMap<>();


    public void addSubscriberToLocations(Client client, Location location) {
        Set<Location> locations = new HashSet<>();
        if (this.clientLocationsMap.get(client) == null) {
            this.clientLocationsMap.put(client, locations);
        } else
            locations = this.clientLocationsMap.get(client);
        locations.add(location);
        this.clientLocationsMap.put(client, locations);


    }

    public void removeSubscriberFromLocation(Client client, Location location) {
        Set<Location> locations = this.clientLocationsMap.get(client);
        if (locations.contains(location)) {
            locations.remove(location);
            if (locations.size() == 0)
                this.clientLocationsMap.remove(client);
        }
    }

    public void sendNotificationToLocations(Notification notification, Location location) {
        this.clientLocationsMap.forEach((client, locations) -> client.receive(notification));

    }

    public void sendNotificationToAllClients(Notification notification) {
        for (Map.Entry<Client, Set<Location>> client : clientLocationsMap.entrySet()) {
            Client key = client.getKey();
            key.receive(notification);
        }
    }


    public void display() {   // metoda pomocnicza
        for (Map.Entry<Client, Set<Location>> pair : clientLocationsMap.entrySet()) {
            Client key = pair.getKey();                      // Key
            Set<Location> value = pair.getValue();                  // Value
            System.out.println(key + ":" + value);
        }


    }

    public static void main(String[] args) {
        NotificationServiceForWeatherHazards notificationServiceForWeatherHazards = new NotificationServiceForWeatherHazards();
        Client tom = new Client("Tom");
        Client mark = new Client("Mark");
        Location warsaw = new Location("Warsaw");
        Location berlin = new Location("Berlin");
        notificationServiceForWeatherHazards.addSubscriberToLocations(tom, warsaw);
        notificationServiceForWeatherHazards.addSubscriberToLocations(mark, berlin);
        notificationServiceForWeatherHazards.addSubscriberToLocations(tom, berlin);
        notificationServiceForWeatherHazards.display();
        System.out.println();
        notificationServiceForWeatherHazards.removeSubscriberFromLocation(tom, berlin);
        notificationServiceForWeatherHazards.display();
        System.out.println();
        notificationServiceForWeatherHazards.removeSubscriberFromLocation(tom, warsaw);
        notificationServiceForWeatherHazards.display();
        notificationServiceForWeatherHazards.sendNotificationToLocations(new Notification("Storm"), berlin);
        notificationServiceForWeatherHazards.sendNotificationToAllClients(new Notification("Alarm"));

    }
}