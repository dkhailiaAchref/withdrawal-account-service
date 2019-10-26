/*
 * =============================================================================
 *
 *   PRICE MINISTER APPLICATION
 *   Copyright (c) 2000 Babelstore.
 *   All Rights Reserved.
 *
 *   $Source$
 *   $Revision$
 *   $Date$
 *   $Author$
 *
 * =============================================================================
 */
package com.priceminister.account.implementation;

import com.priceminister.account.*;
import org.springframework.beans.factory.annotation.Autowired;


public class CustomerAccountRule implements AccountRule {

    /**
     * Checks if the resulting account balance after a withdrawal is OK
     * for the specific type of account.
     * @param resultingAccountBalance - the amount resulting of the withdrawal
     * @return true if the operation is permitted, false otherwise
     */
    public boolean withdrawPermitted(Double resultingAccountBalance)

    {    CustomerAccount customerAccount=new CustomerAccount();

        return withdrawalPermited(resultingAccountBalance,customerAccount.getBalance());
    }


    public boolean withdrawalPermited ( Double amountWithdrawal,Double amountBalance){

        boolean withdrawalPermited;
        // function call to compare two double values
        if (Double.compare(amountBalance, amountWithdrawal) == 0) {
            withdrawalPermited=true;
        }
        else if (Double.compare(amountWithdrawal, amountBalance) < 0) { //amountWithdrawal<amountBalance
            withdrawalPermited=true;
        }
        else {

            withdrawalPermited=false;
        }
        return withdrawalPermited;
    }


}
