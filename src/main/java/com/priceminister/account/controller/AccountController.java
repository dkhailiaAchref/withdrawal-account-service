package com.priceminister.account.controller;

import com.priceminister.account.implementation.CustomerAccount;
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

        //http://localhost:8080/swagger-ui.html#/accounts/saveUsingPOST
        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        @ApiOperation(value = "enregistrer un nouvel account ")
        public AccountModel add(@RequestBody Double amount) {
            return accountRepository.add(amount);
        }

        //http://localhost:8080/accounts
        @GetMapping
        @ApiOperation(value = "obtenir le current account ")
        public AccountModel getCurrentAccount() {
            return accountRepository.getCurrentAccount();
        }

    }
