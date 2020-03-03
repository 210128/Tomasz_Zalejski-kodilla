package com.kodilla.notification.homework;

public class Notification {
    private String alert;

    public Notification(String alert) {
        this.alert = alert;
    }

    public String getAlert() {
        return alert;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "alert='" + alert + '\'' +
                '}';
    }
}
