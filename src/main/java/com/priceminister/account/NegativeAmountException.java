package com.priceminister.account;

public class NegativeAmountException  extends Exception{


    private Double balance;

    public NegativeAmountException(Double NegativeAmountToAdd) {
        balance = NegativeAmountToAdd;
    }

    public String toString() {
        return "negative value not acepted for amout to add in account balance: " + balance;
    }
}
