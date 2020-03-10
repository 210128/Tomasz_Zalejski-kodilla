package com.kodilla.spring.basic.spring_configuration.homework;

import java.util.Random;

public class Sedan implements Car {
    @Override
    public boolean hasHeadlightsTurnedOn() {
        Random generator = new Random();
        int hour = generator.nextInt(24)+1;
        if (hour >= 20 || hour <= 6) {
            System.out.println("We have an hour "+ hour+ ". Headlights turned on");
            return true;
        } else {
            System.out.println("We have an hour "+ hour+ ". Headlights turned off");
            return false;
        }
    }

    @Override
    public String getCarType() {
        return "Sedan";
    }

    @Override
    public String toString() {
        return "Sedan{}";
    }
}
