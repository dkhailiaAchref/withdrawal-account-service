package com.priceminister.account;

import com.priceminister.account.model.AccountModel;

/**
 * This class represents a simple account.
 * It doesn't handle different currencies, all money is supposed to be of standard currency EUR.
 */
public interface Account {
   static  AccountModel account=new AccountModel() ;
    /**
     * Adds money to this account.
     * @param addedAmount - the money to add
     */
    public AccountModel add(Double addedAmount) throws NegativeAmountException;
    
    /**
     * Withdraws money from the account.
     * @param withdrawnAmount - the money to withdraw
     * @param rule - the AccountRule that defines which balance is allowed for this account
     * @return the remaining account balance
     * @throws IllegalBalanceException if the withdrawal leaves the account with a forbidden balance
     */
    public AccountModel withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) throws IllegalBalanceException;
    
    /**
     * Gets the current account balance.
     * @return the account's balance
     */
    public Double getBalance();

 public AccountModel getCurrentAccount();
}

