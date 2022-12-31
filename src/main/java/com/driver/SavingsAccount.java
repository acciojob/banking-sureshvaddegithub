package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;


    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name,balance,0);
        this.maxWithdrawalLimit=maxWithdrawalLimit;
        this.rate = rate;
        // minimum balance is 0 by default

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if((maxWithdrawalLimit-amount) < 0){
           throw new MaximumWithdrawLimitException("Maximum Withdraw Limit Exceed");
        }
        else if(getBalance()<amount){
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        else{
            maxWithdrawalLimit-=amount;
            setBalance(amount);
        }

    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        int i = 100;
        double simpleInterest = getBalance()+(getBalance()*years)*rate/i;
         return simpleInterest;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
         double compoundrate = rate/times;
         years= years*times;
         double amount = getBalance()*Math.pow((1+(compoundrate/100)),years);
         double compoundInterest = amount-getBalance();
         double ans = getBalance()+compoundInterest;
         return ans;
    }

}
