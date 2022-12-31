package com.driver;

public class Main {
    public static void main(String[] args) {
        try {
            CurrentAccount account = new CurrentAccount("suresh", 6000, "sreie");
            account.generateAccountNumber(1234,10);
            account.withdraw(1000);

        }catch(Exception e){
            System.out.println(e);
        }
        SavingsAccount account = new SavingsAccount("suresh",1000.0,20000.0,8.0);

        System.out.println(account.getCompoundInterest(2,1));

    }
}