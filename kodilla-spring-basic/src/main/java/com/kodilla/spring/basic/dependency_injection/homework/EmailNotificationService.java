package com.kodilla.spring.basic.dependency_injection.homework;

public class EmailNotificationService implements NotificationService {
    @Override
    public void success(String address) {
        System.out.println("Message sending via Email [Package delivered to: " + address + "]");
    }

    @Override
    public void fail(String address) {
        System.out.println("Message sending via Email [Package not delivered to: " + address + "]");
    }
}
