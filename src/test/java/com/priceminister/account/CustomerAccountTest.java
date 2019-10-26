package com.priceminister.account;


import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import com.priceminister.account.init.DataInit;
import org.junit.*;
import com.priceminister.account.implementation.*;


/*
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * <p>
 * We want to see how you "think code", and how you organize and structure a simple application.
 * <p>
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 */


public class CustomerAccountTest {

    Account customerAccount;
    AccountRule rule;

    @Before
    public void setUp() throws Exception {
        customerAccount = new CustomerAccount();
        rule=new CustomerAccountRule();
        DataInit.initData();
    }


//     * Tests that an empty account always has a balance of 0.0, not a NULL.
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        assertEquals(customerAccount.getBalance(), new Double(0.0));
        assertNotNull(customerAccount.getBalance());
    }

    // * Adds money to the account and checks that the new balance is as expected.


    @Test
    public void testAddPositiveAmount() {
        customerAccount.add(new Double(100.0));
        boolean positiveBalance = customerAccount.getBalance() > 0;
        assertTrue(positiveBalance);
    }

    /*
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     * verify in log (Illegal account balance: 1111.1 )
     */

    @Test
    public void testWithdrawAndReportBalanceIllegalBalance() throws IllegalBalanceException {
        Double currentBalance = customerAccount.getBalance();
        customerAccount.withdrawAndReportBalance(currentBalance + new Double(1111.1), rule);
    }

    // Also implement missing unit tests for the above functionalities.

}
