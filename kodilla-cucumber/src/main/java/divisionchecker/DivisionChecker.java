package divisionchecker;

public class DivisionChecker {
    public String checkIfDivisibleBy3Or5(Integer number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        } else if (number % 3 == 0)
            return "Fizz";
        else if (number % 5 == 0)
            return "Buzz";
        return "None";
    }
}