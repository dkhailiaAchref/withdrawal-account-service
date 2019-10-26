package com.priceminister.account.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountModel {

    private Long id;
    Amount amount ;
    Amount withdrawnAmount;

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public Amount getWithdrawnAmount() {
        return withdrawnAmount;
    }

    public void setWithdrawnAmount(Amount withdrawnAmount) {
        this.withdrawnAmount = withdrawnAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
