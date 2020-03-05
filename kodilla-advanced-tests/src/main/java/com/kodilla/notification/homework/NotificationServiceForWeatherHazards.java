package com.kodilla.notification.homework;

import java.util.*;

public class NotificationServiceForWeatherHazards {
    public final Map<Client, Set<Location>> clientLocationsMap = new HashMap<>();


    public void addSubscriberToLocation(Client client, Location location) {
        if (!this.clientLocationsMap.containsKey(client)) {
            this.clientLocationsMap.put(client, new HashSet<>(Collections.singletonList(location)));
        } else {
            var locations = clientLocationsMap.get(client);
            locations.add(location);
            this.clientLocationsMap.put(client, locations);
        }
    }

    public void removeSubscriberFromLocation(Client client, Location location) {
        if (client == null)
            return;
        Set<Location> locations = this.clientLocationsMap.get(client);
        if (locations.contains(location)) {
            locations.remove(location);
            if (locations.size() == 0)
                this.clientLocationsMap.remove(client);
        }
    }

    public void sendNotificationToLocations(Notification notification, Location location) {
        this.clientLocationsMap.forEach((client, locations) -> client.receive(notification, location));
        //this.clientLocationsMap.keySet().forEach(c -> getClientLocation(c).forEach(l -> c.receive(notification, location)));
    }

    public Set<Location> getClientLocation(Client client) {
        return clientLocationsMap.get(client);
    }

    public void sendNotificationToAllClients(Notification notification) {
        this.clientLocationsMap.keySet().forEach(c -> c.receive(notification));
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
        notificationServiceForWeatherHazards.addSubscriberToLocation(tom, warsaw);
        notificationServiceForWeatherHazards.addSubscriberToLocation(mark, berlin);
        notificationServiceForWeatherHazards.addSubscriberToLocation(tom, berlin);
        notificationServiceForWeatherHazards.display();
        System.out.println();

        notificationServiceForWeatherHazards.sendNotificationToLocations(new Notification("Storm"), berlin);
        System.out.println();
        notificationServiceForWeatherHazards.sendNotificationToAllClients(new Notification("Zmiana regulaminu"));

    }
}