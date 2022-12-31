package com.driver;

public class InsufficientBalanceException extends Exception{

    public InsufficientBalanceException(String name){
        System.out.println(name);
    }
}
