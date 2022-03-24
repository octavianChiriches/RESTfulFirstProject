package com.methodchaining;

public class PersonDSL {

    private String name;
    private int id;
    private AccountDSL account;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public AccountDSL getAccount() {
        return account;
    }

    public PersonDSL name(String name) {
        this.name = name;
        return this;
    }

    public PersonDSL id(int id) {
        this.id = id;
        return this;
    }

    public AccountDSL withAccount (AccountDSL account) {
        this.account = account;
        return account;
    }
}
