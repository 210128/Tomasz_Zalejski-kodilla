package divisionchecker;

import io.cucumber.java8.En;
import org.junit.Assert;

/*Review: pls don't start class name with non-captal letter*/
public class IfNumberIsDivisibleBy3And5Steps implements En {
    private Integer number;
    private String answer;

    public IfNumberIsDivisibleBy3And5Steps() {
        Given("I enter {int}", (Integer int1) -> {
            this.number = int1;
        });
        When("I am checking if the number is divisible", () -> {
            DivisionChecker divisionChecker = new DivisionChecker();
            this.answer = divisionChecker.checkIfDivisibleBy3Or5(this.number);
        });

        Then("I should say {string}", (String string) -> {
            Assert.assertEquals(string, this.answer);
        });
    }
}
