package com.priceminister.account.init;

import com.priceminister.account.implementation.CustomerAccount;
import org.springframework.stereotype.Component;


public class DataInit  {


    public static void initData() throws Exception {
         CustomerAccount customerAccount=new CustomerAccount();
            //init the balance amount in account model instance in Acount interface
            customerAccount.add(new Double(0.0));

        }

}

