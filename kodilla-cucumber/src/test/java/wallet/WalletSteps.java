package wallet;

import io.cucumber.java8.En;
import org.junit.Assert;

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
        Then("$200 should be dispensed", () -> {
            Assert.assertEquals(200, cashSlot.getContents());
        });
        Then("$1 should be dispensed", () -> {
            Assert.assertEquals(1, cashSlot.getContents() );
        });
    }
}
