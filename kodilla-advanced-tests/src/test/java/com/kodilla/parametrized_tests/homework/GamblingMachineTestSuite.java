package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GamblingMachineTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/intUserNumbers.csv", numLinesToSkip = 1)
    void testHowManyWins_WithException(int a, int b, int c, int d, int e, int f) {
        GamblingMachine gamble = new GamblingMachine();
        Integer[] data = {a, b, c, d, e, f};
        Set<Integer> numbers = new HashSet<>(Arrays.asList(data));
        assertThrows(InvalidNumbersException.class, () -> gamble.howManyWins(numbers));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/intUserNumbers.csv")
    void testHowManyWins_WithExceptionWhenNotEnoughNumbersAreGiven(int a, int b, int c, int d, int e) {
        GamblingMachine gamble = new GamblingMachine();
        Integer[] data = {a, b, c, d, e};
        Set<Integer> numbers = new HashSet<>(Arrays.asList(data));
        assertThrows(InvalidNumbersException.class, () -> gamble.howManyWins(numbers));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/intUserNumbers1.csv")
    void testHowManyWins_WithExceptionWhenToManyNumbersAreGiven(int a, int b, int c, int d, int e, int f, int g){
        GamblingMachine gamble = new GamblingMachine();
        Integer[] data = {a, b, c, d, e, f, g};
        Set<Integer> numbers = new HashSet<>(Arrays.asList(data));
        assertThrows(InvalidNumbersException.class, () -> gamble.howManyWins(numbers));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/properIntUserNumbers.csv")
    void shouldReturnTrueWhenWeEnter6NumbersInRange1To49HowManyWins(int a, int b, int c, int d, int e, int f) throws InvalidNumbersException {
        GamblingMachine gamble = new GamblingMachine();
        Integer[] data = {a, b, c, d, e, f};
        Set<Integer> numbers = new HashSet<>(Arrays.asList(data));
        assertTrue(gamble.howManyWins(numbers) >= 0 && gamble.howManyWins(numbers) <= 6);
    }
}