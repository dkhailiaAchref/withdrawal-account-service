package com.priceminister.account.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountModel {
    Amount amount ;
    List<Amount> withdrawnAmountHistory;

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public List<Amount> getWithdrawnAmountHistory() {
        return withdrawnAmountHistory;
    }

    public void setWithdrawnAmountHistory(List<Amount> withdrawnAmount) {
        this.withdrawnAmountHistory = withdrawnAmount;
    }

}
