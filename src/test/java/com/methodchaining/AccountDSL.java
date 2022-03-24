package com.methodchaining;

public class AccountDSL {

    private double balance;

    public AccountDSL() {
        this.balance = 0;
    }

    public AccountDSL(double balance) {
        this.balance = balance;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public double getBalance() {
        return balance;
    }

    public AccountDSL withdraw(double amount) {
        balance -= amount;
        return this;
    }

    public void printBalance() {
        System.out.println(balance);
    }

    public AccountDSL andThen() {
        return this;
    }

}
