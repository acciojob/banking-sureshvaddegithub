package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
          this.name = name;
          this.balance = balance;
          this.minBalance = minBalance;
    }

    public void setBalance(double balance) {
        this.balance-= balance;
    }

    public double getBalance() {
        return balance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        String s = String.valueOf(digits);
        int sumOfDigits=0;
        for(int i= 0;i<s.length();i++){
            char  ch = s.charAt(i);
            if(Character.isDigit(ch))
                sumOfDigits+=ch-'0';
            else
                throw new AccountCannotGenerationException("Account Number can not be generated");
        }
            if(sumOfDigits!=sum)
            throw new AccountCannotGenerationException("Account Number can not be generated");

        return null;
    }

    public void deposit(double amount) {
        //add amount to balance
         this.balance+=amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
         if((balance-amount)<minBalance){
             throw new InsufficientBalanceException("Insufficient Balance");
         }
         else{
             balance-=amount;
         }
    }

}