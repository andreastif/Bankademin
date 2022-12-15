package org.example.Model;

public class Account {

    private final String accountName;
    private int balance;

    public Account(String accountName, int balance){
        this.accountName = accountName;
        this.balance = balance;
    }

    public void increaseBalance(int amount) {
        this.balance = balance + amount;
    }

    public void decreaseBalance(int amount) {
        this.balance = balance - amount;
    }

    public int getBalance() {
        return balance;
    }


    public String getAccountName() {
        return accountName;
    }

    @Override
    public String toString() {
        return  "\nAccount Name: " + accountName +
                "\nBalance: " + balance;
    }
}
