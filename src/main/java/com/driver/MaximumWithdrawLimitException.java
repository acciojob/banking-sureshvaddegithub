package com.driver;

public class MaximumWithdrawLimitException extends Exception{

    public MaximumWithdrawLimitException(String name){
        System.out.println(name);
    }
}
