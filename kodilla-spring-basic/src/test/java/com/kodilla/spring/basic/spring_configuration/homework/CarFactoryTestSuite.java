package com.kodilla.spring.basic.spring_configuration.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class CarFactoryTestSuite {

    @Test
    public void shouldCreateCabrio() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_configuration");
        Cabrio cabrio = context.getBean(Cabrio.class);
        //When
        String carType = cabrio.getCarType();
        //Then
        Assertions.assertEquals("Cabrio", carType);
    }

    @Test
    public void shouldCreateSUVBeanAndFetchByName() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_configuration");
        SUV suv = (SUV) context.getBean("createSUV");
        //When
        String carType1 = suv.getCarType();
        //Then
        Assertions.assertEquals("SUV", carType1);
    }

    @Test
    public void shouldCreateRandomCarBasedOnSeasonOfYear() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_configuration");
        Car car = (Car) context.getBean("randomCar");
        //When
        String carType = car.getCarType();
        System.out.println(carType);
        //Then
        List<String> possibleCars = Arrays.asList("Cabrio", "Sedan", "SUV");
        Assertions.assertTrue(possibleCars.contains(carType));
    }
}