package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalculatorTestSuite {

    @Test
    public void shouldDisplayValue() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        Display bean = context.getBean(Display.class);
        double value = bean.display(4);
        Assertions.assertEquals(4, value);
    }

    @Test
    public void shouldCalculateSum() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        Calculator bean = context.getBean(Calculator.class);
        double value = bean.add(2, 2);
        Assertions.assertEquals(4.0, value);
    }

    @Test
    public void shouldCalculateSubtract() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        Calculator bean = context.getBean(Calculator.class);
        double value = bean.subtract(2, 2);
        Assertions.assertEquals(0.0, value);
    }

    @Test
    public void shouldCalculateMultiply() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        Calculator bean = context.getBean(Calculator.class);
        double value = bean.multiply(2, 2.5);
        Assertions.assertEquals(5.0, value);
    }

    @Test
    public void shouldCalculateDivide() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        Calculator bean = context.getBean(Calculator.class);
        double value = bean.divide(10, 2.5);
        Assertions.assertEquals(4.0, value);
    }
}