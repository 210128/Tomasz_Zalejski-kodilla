package com.kodilla.spring.basic.spring_configuration.homework;

public class Cabrio implements Car {
    @Override
    public boolean hasHeadlightsTurnedOn(Integer hour) {

        int hours = hour;
        boolean isNight = (hours >= 20 || hours <= 6);
        String msg = isNight ? "on" : "off";
        System.out.println("We have an hour " + hours + ". Headlights turned " + msg);
        return isNight;
    }

    @Override
    public String getCarType() {
        return "Cabrio";
    }

    @Override
    public String toString() {
        return "Cabrio{}";
    }
}
