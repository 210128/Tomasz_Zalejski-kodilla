package com.kodilla.notification.homework;

import java.util.List;

public class Location {
    private String locationName;

    public Location(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationName() {
        return locationName;
    }

    @Override
    public String toString() {
        return " Location: " +
                locationName;
    }
}
