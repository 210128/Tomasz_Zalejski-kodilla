package com.kodilla.notification.homework;

public class Client {
private  String username;

    public Client(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void receive(Notification notification) {

    }

    @Override
    public String toString() {
        return "Client " + username ;
    }
}
