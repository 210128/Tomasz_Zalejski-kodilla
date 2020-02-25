package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GamblingMachineTest {
    private GamblingMachine gamble = new GamblingMachine();

    @ParameterizedTest
    @CsvFileSource(resources = "/intUserNumbers.csv", numLinesToSkip = 1)
    public void testHowManyWins_WithException(int a, int b, int c, int d, int e, int f){// TODO remove throws InvalidNumbersException {
        Integer[] data = {a, b, c, d, e, f};
        Set<Integer> numbers = new HashSet<>(Arrays.asList(data));
        assertThrows(InvalidNumbersException.class, () -> gamble.howManyWins(numbers));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/intUserNumbers.csv")
    public void testHowManyWins_WithExceptionWhenNotEnoughNumbersAreGiven(int a, int b, int c, int d, int e){//TODO remove  throws InvalidNumbersException {
        Integer[] data = {a, b, c, d, e};
        Set<Integer> numbers = new HashSet<>(Arrays.asList(data));
        assertThrows(InvalidNumbersException.class, () -> gamble.howManyWins(numbers));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/intUserNumbers1.csv")
    public void testHowManyWins_WithExceptionWhenToManyNumbersAreGiven(int a, int b, int c, int d, int e, int f, int g){//TODO remove throws InvalidNumbersException {
        Integer[] data = {a, b, c, d, e, f, g};
        Set<Integer> numbers = new HashSet<>(Arrays.asList(data));
        assertThrows(InvalidNumbersException.class, () -> gamble.howManyWins(numbers));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/properIntUserNumbers.csv")
    public void shouldReturnTrueWhenWeEnter6NumbersInRange1To49HowManyWins(int a, int b, int c, int d, int e, int f) throws InvalidNumbersException {
        Integer[] data = {a, b, c, d, e, f};
        Set<Integer> numbers = new HashSet<>(Arrays.asList(data));
        System.out.println(gamble.howManyWins(numbers));
        assertTrue(gamble.howManyWins(numbers) >= 0 && gamble.howManyWins(numbers) <= 6);
    }
}