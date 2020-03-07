package com.kodilla.spring.basic.dependency_injection.homework;

public class FacebookNotificationService implements NotificationService {
    @Override
    public void success(String address) {
            System.out.println("Message sending using Facebook [Package delivered to: " + address + "]");
    }

    @Override
    public void fail(String address) {
        System.out.println("Message sending using Facebook [Package not delivered to: " + address + "]");
    }
}
