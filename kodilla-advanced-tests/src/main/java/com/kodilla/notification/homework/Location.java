package com.kodilla.notification.homework;

import java.util.List;
import java.util.Objects;

public class Location {
    private String locationName;

    public Location(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationName() {
        return locationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(locationName, location.locationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationName);
    }

    @Override
    public String toString() {
        return " Location: " +
                locationName;
    }
}
