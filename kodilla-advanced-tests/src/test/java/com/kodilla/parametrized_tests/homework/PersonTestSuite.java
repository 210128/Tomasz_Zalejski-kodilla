package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class PersonTestSuite {

    @ParameterizedTest
    @MethodSource(value = "com.kodilla.parametrized_tests.homework.IntSources#provideIntForTestingBMI")
    public void testGetBmi(double height, double weight, String output) {
        assertEquals(output, new Person(height, weight).getBMI());
    }

}