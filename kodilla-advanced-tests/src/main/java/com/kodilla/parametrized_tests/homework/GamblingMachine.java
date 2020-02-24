package com.kodilla.parametrized_tests.homework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class GamblingMachine {
    public int howManyWins(Set<Integer> userNumbers) throws InvalidNumbersException {
        validateNumbers(userNumbers);
        Set<Integer> computerNumbers = generateComputerNumbers();
        int count = 0;
        for (Integer number : userNumbers) {
            if (computerNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
    private void validateNumbers(Set<Integer> numbers) throws InvalidNumbersException {
        if(numbers.size() != 6){
            throw new InvalidNumbersException();
        }
        if ((numbers.stream().anyMatch(number -> number <1))) {
            throw new InvalidNumbersException();
        }
    }
    private Set<Integer> generateComputerNumbers() {
        Set<Integer> numbers = new HashSet<>();
        Random generator = new Random();
        while (numbers.size() <6){
            numbers.add(generator.nextInt(49 )+1);
        }
        return numbers;
    }

    public static void main(String[] args) throws InvalidNumbersException {
        GamblingMachine gamblingMachine = new GamblingMachine();
       Integer[] zz={1,2,3,4,5,49};
       Set<Integer> userNumbers = new HashSet<>(Arrays.asList(zz));
        System.out.println(userNumbers.size());
        System.out.println(gamblingMachine.generateComputerNumbers());
        System.out.println(gamblingMachine.howManyWins(userNumbers));

    }
}
