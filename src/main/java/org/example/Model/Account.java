package org.example.Model;

public class Account {

    private final String accountNumber;
    private double balance;

    public Account(String accountName, double balance){
        this.accountNumber = accountName;
        this.balance = balance;
    }

    public void increaseBalance(double amount) {
        this.balance = balance + amount;
    }

    public void decreaseBalance(double amount) {
        this.balance = balance - amount;
    }

    public double getBalance() {
        return balance;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return  "\nAccount Name: " + accountNumber +
                "\nBalance: " + balance;
    }
}
