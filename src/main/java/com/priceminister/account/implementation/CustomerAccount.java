package com.priceminister.account.implementation;

import com.priceminister.account.*;
import com.priceminister.account.model.Amount;
import com.priceminister.account.model.AccountModel;
import org.springframework.stereotype.Component;

import java.util.Currency;
import java.util.logging.Logger;

/**
 * * Acount.acount model  doesn't handle different currencies, all money is supposed to be of standard currency EUR.
 */
@Component
public class CustomerAccount implements Account {
    protected static Logger log=
            Logger.getLogger("CustomerAccount");

    public AccountModel add(Double addedAmount) {
        //save Amount into account model instance in Acount interface
        Account.account.setAmount(new Amount(addedAmount, Currency.getInstance("EUR")));
        return Account.account;
    }

    //solde courant du compte
    public Double getBalance() {
        AccountModel account = Account.account;
        Double balance= account.getAmount().getAmount();
        return balance;
    }

    /**
     * Withdraws money from the account.
     *
     * @param withdrawnAmount - the money to withdraw
     * @param rule            - the AccountRule that defines which balance is allowed for this account
     * @return the remaining account balance
     * @throws IllegalBalanceException if the withdrawal leaves the account with a forbidden balance
     */
    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule)
            throws IllegalBalanceException {
        Double remainingBalance = new Double(0);
        if (rule.withdrawPermitted(withdrawnAmount)) { //this.getBalance() >= withdrawnAmount
            //withdraw And Report Balance
            remainingBalance = this.getBalance() - withdrawnAmount;
            log.info("the remaining Balance in current account is " + remainingBalance);
        }
        else { //this.getBalance() < withdrawnAmount => not permitted because , withdrawal leaves the account with a forbidden balance
            throw new IllegalBalanceException(withdrawnAmount);
        }

        return remainingBalance;
    }

    public AccountModel getCurrentAccount(){

        return Account.account;
    }

}
