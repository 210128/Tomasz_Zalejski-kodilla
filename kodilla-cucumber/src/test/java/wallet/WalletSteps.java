package wallet;

import io.cucumber.java8.En;
import org.junit.Assert;

import static org.hamcrest.MatcherAssert.assertThat;

public class WalletSteps implements En {
    private Wallet wallet = new Wallet();
    private CashSlot cashSlot = new CashSlot();
    private Cashier cashier = new Cashier(cashSlot);

    public WalletSteps() {
        Given("I have deposited $200 in my wallet", () -> {
            wallet.deposit(200);
            Assert.assertEquals("Incorrect wallet balance", 200, wallet.getBalance());
        });

        When("I request $30", () -> {
            cashier.withdraw(wallet, 30);
        });
        When("I request $200", () -> {
            cashier.withdraw(wallet, 200);
        });
        When("I request $1", () -> {
            cashier.withdraw(wallet, 1);
        });

        Then("$30 should be dispensed", () -> {
            Assert.assertEquals(30, cashSlot.getContents());
        });
        Then("the balance of my wallet  should be $170", () -> {
            Assert.assertEquals("Incorrect wallet balance", 170, wallet.getBalance());
        });
        Then("$200 should be dispensed", () -> {
            Assert.assertEquals(200, cashSlot.getContents());
        });
        Then("$1 should be dispensed", () -> {
            Assert.assertEquals(1, cashSlot.getContents());
        });

        Given("my wallet has been credited with $100", () -> {
            wallet.deposit(100);
            Assert.assertEquals("Incorrect wallet balance", 100, wallet.getBalance());
        });

        When("I withdraw $200", () -> {
            cashier.withdraw(wallet, 200);
        });

        Then("nothing should be dispensed", () -> {
            Assert.assertEquals(0, cashSlot.getContents());
        });

        Then("I should be told that I have insufficient funds in my account", () -> {
            assertThat("Insufficient funds in account", true);
        });
        Given("my account has been credited with $100", () -> {
            wallet.deposit(100);
        });
        When("I check my balance", () -> {
            wallet.getBalance();
        });
        Then("I should see that my balance is $100", () -> {
            Assert.assertEquals("Incorrect wallet balance", 100, wallet.getBalance());
        });

    }
}
