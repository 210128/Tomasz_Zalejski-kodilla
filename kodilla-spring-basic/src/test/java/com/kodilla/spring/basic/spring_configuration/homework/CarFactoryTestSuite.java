package com.kodilla.spring.basic.spring_configuration.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class CarFactoryTestSuite {
    @Autowired
    private Cabrio cabrio;

    @Test
    public void shouldReturnTrueIfLightsAreOninCabrio() {
        Assertions.assertTrue(cabrio.hasHeadlightsTurnedOn(23));
    }

    @Test
    public void shouldReturnFalseIfLightsAreOffBetween6AmTo20() {
        Assertions.assertFalse(cabrio.hasHeadlightsTurnedOn(12));
    }

    @Test
    public void shouldCreateCabrio() {
        String carType = cabrio.getCarType();
        //Then
        Assertions.assertEquals("Cabrio", carType);
    }

    @Test
    public void shouldCreateSUVBeanAndFetchByName() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_configuration");
        SUV suv = context.getBean("suv", SUV.class);
        //When
        String carType1 = suv.getCarType();
        //Then
        Assertions.assertEquals("SUV", carType1);
    }

    @Test
    public void shouldCreateRandomCarBasedOnSeasonOfYear() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_configuration");
        Car car = context.getBean("randomCar", Car.class);
        //When
        String carType = car.getCarType();
        System.out.println(carType);
        //Then
        List<String> possibleCars = Arrays.asList("Cabrio", "Sedan", "SUV");
        Assertions.assertTrue(possibleCars.contains(carType));
    }
}