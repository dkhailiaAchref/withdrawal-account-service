package com.priceminister.account.controller;

import com.priceminister.account.IllegalBalanceException;
import com.priceminister.account.NegativeAmountException;
import com.priceminister.account.implementation.CustomerAccount;
import com.priceminister.account.implementation.CustomerAccountRule;
import com.priceminister.account.model.AccountModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/accounts")
@Api(tags = {"accounts"})
public class AccountController {

    @Autowired
    private CustomerAccount accountRepository;

    //https://localhost:8443/swagger-ui.html#
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "créditer  un  account par un montant")
    public AccountModel add(@RequestBody  Double amount) {
        AccountModel accountAdded = new AccountModel();
        try {
            accountAdded = accountRepository.add(amount);
        } catch (NegativeAmountException e) {
            e.printStackTrace();
        }
        return accountAdded;
    }

    //https://localhost:8443/accounts
    @GetMapping
    @ApiOperation(value = "obtenir le current account ")
    public AccountModel getCurrentAccount() {
        return accountRepository.getCurrentAccount();
    }

    //https://localhost:8443/swagger-ui.html#
    @PostMapping("withdrawAndReportBalance")
    @ApiOperation(value = "effectuer un retrait account+nrapport solde ")
    public AccountModel withdrawAndReportBalance(@RequestBody Double amountRetrait) {
        AccountModel accountRemainingBalance = new AccountModel();
        try {
            accountRemainingBalance = accountRepository.withdrawAndReportBalance(amountRetrait, new CustomerAccountRule());
        } catch (IllegalBalanceException e) {
            e.printStackTrace();
        }
        return accountRemainingBalance;
    }

}
