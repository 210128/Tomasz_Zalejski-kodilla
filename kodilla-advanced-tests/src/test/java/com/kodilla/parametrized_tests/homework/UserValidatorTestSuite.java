package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserValidatorTestSuite {
    private UserValidator validator = new UserValidator();

    @ParameterizedTest
    @ValueSource(strings = {"use", "usErer", "uSer-1", "_user", "u.ser"})
    public void shouldReturnTrueWhenUsernameProvidedIsCorrect(String text) {
        assertTrue(validator.validateUsername(text));
    }

    @ParameterizedTest
    @ValueSource(strings = {"us", "us%Erer", "u!Ser1", "u*ser", "3$43er"})
    public void shouldReturnFalseWhenUsernameProvidedIsNotValid(String text) {
        assertFalse(validator.validateUsername(text));
    }

    @ParameterizedTest
    @ValueSource(strings = {"f@sdsa.com", "ssdsa.ew.q@sdsada332.sdd", "23._sZw@kdsd-wdw2.33422.aSwsda", "_@wu62Z.z"})
    public void shouldReturnTrueWhenEmailProvidedIsCorrect(String text) {
        assertTrue(validator.validateEmail(text));
    }

    @ParameterizedTest
    @ValueSource(strings = {"!@sdsa.com", "ssdsa.ewq@sds_ada332.sdd.wsd", "23._sZw@kd@sdwdw2.33422.aSwsda", "_@wu62Z.z2"})
    public void shouldReturnFalseWhenEmailProvidedIsNotCorrect(String text) {
        assertFalse(validator.validateEmail(text));
    }
}