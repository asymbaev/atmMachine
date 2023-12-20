package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("""
                Choose an option:
                1. create-account
                2. deposit
                3. withdraw
                4. transfer
                5. account-info
                """);
        while (scanner.hasNext()){
            String command = scanner.next();
            switch (command) {
                case "create-account":
                    System.out.println("Please enter your name and phone number");
                    String name = scanner.next();
                    String phoneNumber = scanner.next();
                    bank.createAccount(name, phoneNumber);
                    System.out.println("Your account is successfully created");
                    break;
                case "deposit":
                    System.out.println("Enter the account number and the amount ");
                    bank.deposit(scanner.nextLong(), scanner.nextDouble());
                    break;
                case "withdraw":
                    System.out.println("Pleas enter an amount to withdraw");
                    bank.withdraw(scanner.nextLong(), scanner.nextDouble());
                    break;
                case "transfer":
                    System.out.println("Enter the src account number, des account number and the amount");
                    bank.transfer(scanner.nextLong(), scanner.nextLong(), scanner.nextDouble());
                    break;
                case "account-info":
                    System.out.println("Enter the account number");
                    bank.accountInfo(scanner.nextLong());
                    break;
                default:
                    System.out.println("Invalid Command");
                    scanner.nextLine();

            }
        }
    }
}