package com.methodchaining;

public class PersonPlain {

    private String name;
    private int id;
    private AccountPlain account;

    public String getName() {
        return name;
    }

    public int getId(){
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAccount(AccountPlain account) {
        this.account = account;
    }
}
