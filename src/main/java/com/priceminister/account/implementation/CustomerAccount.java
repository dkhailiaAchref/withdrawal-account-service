package com.priceminister.account.implementation;

import com.priceminister.account.*;
import com.priceminister.account.model.Amount;
import com.priceminister.account.model.AccountModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.logging.Logger;

/**
 * * Acount.acount model  doesn't handle different currencies, all money is supposed to be of standard currency EUR.
 */
@Component
public class CustomerAccount implements Account {
    protected static Logger log=
            Logger.getLogger("CustomerAccount");

    public AccountModel add(Double addedAmount) throws NegativeAmountException{
        //save Amount into account model instance in Acount interface
        if (addedAmount>=0){
            Account.account.setAmount(new Amount(addedAmount, Currency.getInstance("EUR")));
        }else{
            log.info("not permitted add negative amount in account balance ");
            throw new NegativeAmountException(addedAmount);
        }

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
    public AccountModel withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule)
            throws IllegalBalanceException {
        Double remainingBalance = new Double(0);
        if (rule.withdrawPermitted(withdrawnAmount)) { //this.getBalance() >= withdrawnAmount
            //withdraw And Report Balance
            remainingBalance = this.getBalance() - withdrawnAmount;
            log.info("the remaining Balance in current account is " + remainingBalance);

            //Màj current account by remaining Balance
            Account.account.getAmount().setAmount(remainingBalance);
            //historisation des operations de retrais
            List<Amount> actualHistory =this.getCurrentAccount().getWithdrawnAmountHistory ();
            if (actualHistory!=null){
                actualHistory.add(new Amount(withdrawnAmount,Currency.getInstance("EUR")));
            }else {
                actualHistory=new ArrayList<>(); actualHistory.add(new Amount(withdrawnAmount,Currency.getInstance("EUR")));
            }
           //Màj current account by history withdraw
            Account.account.setWithdrawnAmountHistory(actualHistory);
        }
        else { //this.getBalance() < withdrawnAmount => not permitted because , withdrawal leaves the account with a forbidden balance
            throw new IllegalBalanceException(withdrawnAmount);
        }

        return Account.account;
    }

    public AccountModel getCurrentAccount(){

        return Account.account;
    }



}
