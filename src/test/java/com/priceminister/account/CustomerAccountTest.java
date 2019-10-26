package com.priceminister.account;


import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import com.priceminister.account.init.DataInit;
import com.priceminister.account.model.AccountModel;
import org.junit.*;
import com.priceminister.account.implementation.*;
import static org.assertj.core.api.Assertions.assertThat;



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
        rule = new CustomerAccountRule();
        DataInit.initData();
    }


    //     * Tests that an empty account always has a balance of 0.0, not a NULL.
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        assertEquals(customerAccount.getBalance(), new Double(0.0));
        assertNotNull(customerAccount.getBalance());
    }

    // Adds money to the account and checks that the new balance is as expected.
    @Test
    public void testAddPositiveAmount() throws NegativeAmountException {
        customerAccount.add(new Double(100.0));
        boolean positiveBalance = customerAccount.getBalance() > 0;
        assertTrue(positiveBalance);
    }


/**
     * Adds negative value for money to the account should throws the expected exception..
     * verify in log:
     * INFO: not permitted add negative amount in account balance
     * negative value not acepted for amout to add in account balance: -100.0
     */


    @Test
    public void testAddNegativeAmount() throws NegativeAmountException {
        customerAccount.add(new Double(-100));
        boolean negativeBalance = customerAccount.getBalance() < 0;
        assertTrue(negativeBalance);
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


/*
     * Tests that an permitted withdrawal .
     * currentBalance = 2222.2
     * operation 1: withdrawnAmount=1111.1 =>   request operation permitted
     * verify in log => INFO: the remaining Balance in current account is 1111.1
     * operation 2 :  withdrawnAmount=1111.1  =>   request operation permitted
     *verify in log => INFO: the remaining Balance in current account is 0.0
     *  assert number of history operation=2
     */

    @Test
    public void testWithdrawAndReportBalancePermitted() throws IllegalBalanceException, NegativeAmountException {
        customerAccount.add(new Double(2222.2));
        Double currentBalance = customerAccount.getBalance();
        //operation 1
        AccountModel accountRemainingBalance = customerAccount.withdrawAndReportBalance(new Double(1111.1), rule);
        boolean positiveRemainingBalance = accountRemainingBalance.getAmount().getAmount() > 0;
        assertTrue(positiveRemainingBalance);
        //operation 2
        accountRemainingBalance = customerAccount.withdrawAndReportBalance(new Double(1111.1), rule);
        positiveRemainingBalance = accountRemainingBalance.getAmount().getAmount() >= 0;
        assertTrue(positiveRemainingBalance);
        //assert number of history operation=2
        Integer sizeHistory =accountRemainingBalance.getWithdrawnAmountHistory().size();
        assertThat(sizeHistory).isEqualTo(new Integer(2));




    }
}

