package org.example.Model;

public class Account {

    String accountName;
    int balance;

    public Account(String accountName, int balance){
        this.accountName = accountName;
        this.balance = balance;
    }


    @Override
    public String toString() {
        return  "\nAccount Name: " + accountName +
                "\nBalance: " + balance;
    }
}
