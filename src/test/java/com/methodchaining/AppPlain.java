package com.methodchaining;

public class AppPlain {

    public static void main(String[] args) {

        PersonPlain p = new PersonPlain();

        p.setId(3);
        p.setName("John");
        p.setAccount(new AccountPlain());

        System.out.println(p.getName());
        System.out.println(p.getId());
    }
}
