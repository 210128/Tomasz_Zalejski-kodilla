package com.kodilla.notification.homework;

import java.util.Objects;

public class Client {
    private final String username;

    public Client(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void receive(Notification notification, Location location) {
        System.out.println(location + " " + notification);
    }

    public void receive(Notification notification) {
        System.out.println(notification);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(username, client.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "Client " + username;
    }
}
