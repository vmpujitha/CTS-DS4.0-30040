// File: BankAccountTest.java
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {
    private BankAccount account;

    // Setup method (runs before each test)
    @Before
    public void setUp() {
        account = new BankAccount(1000); // Arrange
    }

    // Teardown method (runs after each test)
    @After
    public void tearDown() {
        account = null;
    }

    @Test
    public void testDeposit() {
        // Act
        account.deposit(500);

        // Assert
        assertEquals(1500, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        // Act
        account.withdraw(300);

        // Assert
        assertEquals(700, account.getBalance());
    }
}
