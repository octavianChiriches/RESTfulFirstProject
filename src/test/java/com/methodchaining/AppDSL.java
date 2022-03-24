package com.methodchaining;

public class AppDSL {

    public static void main(String[] args) {

        double balance = new PersonDSL()
                .id(1)
                .name("John")
                .withAccount(new AccountDSL(10))
                .withdraw(5)
                .getBalance();

        System.out.println(balance);

    }
}
