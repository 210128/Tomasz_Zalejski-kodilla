package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
    private Display display;

    public Calculator(Display display) {
        this.display = display;
    }

    public double add(double a, double b) {
        double value = a + b;
        return this.display.display(value);
    }

    public double subtract(double a, double b) {
        double value = a - b;
        return this.display.display(value);
    }

    public double multiply(double a, double b) {
        double value = a * b;
        return this.display.display(value);
    }

    public double divide(double a, double b) {
        double value = a / b;
        return this.display.display(value);
    }
}
