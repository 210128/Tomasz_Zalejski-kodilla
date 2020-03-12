package com.kodilla.spring.basic.spring_configuration.homework;

import java.util.Random;

public class SUV implements Car {
    @Override

    public boolean hasHeadlightsTurnedOn() {/*TODO Review kdrzazga Should return Bean, not boolean*/
        Random generator = new Random();
        int hour = generator.nextInt(24)+1;

        /*TODO Review kdrzazga: utwórz metodę, która będzie zwracać beana w zależności od pory roku
        *  should depend on season, not only hour*/
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
        return "SUV";
    }

    @Override
    public String toString() {
        return "SUV{}";
    }
}
