package com.kodilla.spring.basic.spring_configuration.homework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class CarFactory {

    @Bean
    public Cabrio createCabrio() {
        return new Cabrio();
    }

    @Bean
    public SUV createSUV() {
        return new SUV();
    }

    @Bean
    public Car randomCar() {
        Car car;
        Random generator = new Random();
        int season = generator.nextInt(12) + 1;
        if (season > 0 && season < 3 || season == 12) {
            car = new SUV();
        } else if (season > 2 && season < 6) {
            car = new Sedan();
        } else if (season > 5 && season < 9) {
            car = new Cabrio();
        } else {
            car = new Sedan();
        }
        return car;
    }
}
