package com.techelevator.models;

import java.math.BigDecimal;

public class ProvideChange {

    public void calcChange(BigDecimal currentBalance){
        int quarters = 0;
         int dimes = 0;
         int nickels = 0;
         int penny = 0;

        while(currentBalance.compareTo(new BigDecimal("0.25")) >= 0){
            quarters++;
            currentBalance = currentBalance.subtract(new BigDecimal("0.25"));
        }
        while(currentBalance.compareTo(new BigDecimal("0.10")) >= 0){
            dimes++;
            currentBalance = currentBalance.subtract(new BigDecimal("0.10"));
        }
        while(currentBalance.compareTo(new BigDecimal("0.05")) >= 0){
            nickels++;
            currentBalance = currentBalance.subtract(new BigDecimal("0.05"));
        }
        while(currentBalance.compareTo(new BigDecimal("0.01")) >= 0){
            penny++;
            currentBalance = currentBalance.subtract(new BigDecimal("0.01"));
        }

        System.out.println("Here is your change. quarters: " + quarters + ", dimes: " + dimes + ", nickels: " + nickels + ", pennies: " + penny);
    }
}
