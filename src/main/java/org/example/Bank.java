package org.example;


import java.util.HashMap;
import java.util.Map;

/**
 * This class has all the operations performed by the bank
 */


public class Bank  {

    private Map<Long, Account> accounts = new HashMap<>();

    // Create Account
    //accountInformation
    //deposit
    //withdraw
    //transfer

    public void createAccount(String name, String phoneNumber) {

        long accountId = System.currentTimeMillis();

        Account account = new Account(name, phoneNumber, accountId, 0);

        accounts.put(accountId, account);

        System.out.println("Account number: " + accountId);
    }

    public void accountInfo(long accountId) {

        Account acc = accounts.get(accountId);

        if (acc == null) {
            System.out.println("Account not found");
        } else {
            System.out.println("Ok ");
            System.out.println("Name: " + acc.getCustomerName());
            System.out.println("Phone: " + acc.getPhoneNumber());
            System.out.println("Balance " + acc.getBalance());

        }
    }

    public void deposit(long accountId, double amount) {
        Account acc = accounts.get(accountId);
        if (acc == null) {
            System.out.println("Account not found");

        }
        else if (amount < 0) {
            System.out.println("Invalid Input");
            
        }
        else {
            acc.setBalance(acc.getBalance() + amount);
            System.out.println("Amount is successfully deposited");
        }
    }

    public void withdraw(long accountId, double amount){

        Account acc = accounts.get(accountId);

        if (acc == null) {
            System.out.println("Account not found");

        }
        else if (amount < 0) {
            System.out.println("Invalid Input");

        } else if (acc.getBalance() < amount) {
            System.out.println("Insufficient Balance");
            
        } else {
            acc.setBalance(acc.getBalance() - amount);
            System.out.println("Amount is successfully withdrawn");
        }

    }
    public void transfer(long source, long destination, double amount) {
        Account src = accounts.get(source);
        Account des = accounts.get(destination);

        if (src == null || des == null) {
            System.out.println("Account not found");

        }
        else if (amount < 0) {
            System.out.println("Invalid Input");

        } else if (src.getBalance() < amount) {
            System.out.println("Insufficient Balance");

        } else {
            src.setBalance(src.getBalance() - amount);
            des.setBalance(des.getBalance() + amount);
        }


    }
}
