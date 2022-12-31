package com.driver;

import java.util.HashMap;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name,balance,5000);
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        if(balance<5000){
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        this.tradeLicenseId=tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        boolean isValidate = true;
        for(int i = 0;i<tradeLicenseId.length()-1;i++){
            if(tradeLicenseId.charAt(i)==tradeLicenseId.charAt(i+1)){
                isValidate = false;
            }
        }
        if (isValidate == false) {
            HashMap<Character,Integer> frequencyOfCharacter = new HashMap<>();
            for(int i =0;i<tradeLicenseId.length();i++)
                frequencyOfCharacter.put(tradeLicenseId.charAt(i),frequencyOfCharacter.getOrDefault(tradeLicenseId.charAt(i),0)+1);
            int max = 0;
            for(int i:frequencyOfCharacter.values()){
                max = Math.max(max,i);
            }
            if(max>(1+tradeLicenseId.length())/2)
                throw new ValidLicenseException("Valid License can not be generated");
        }

    }

}
