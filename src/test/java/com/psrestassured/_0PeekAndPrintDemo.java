package com.psrestassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class _0PeekAndPrintDemo {

    public static final String BASE_URL = "https://api.github.com";

    // Debugging Methods

    @Test
    public void peek() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.get(BASE_URL)
                .peek();
    }

    @Test
    public void prettyPeek() {
        RestAssured.get(BASE_URL)
                .prettyPeek();
    }

    @Test // prints the response body as a String; (if you want to include the body into a report)
    public void print() {
        RestAssured.get(BASE_URL)
                .print();
    }

    @Test // prints the response body as a String;
    public void prettyPrint() {
        RestAssured.get(BASE_URL)
                .prettyPrint();
    }
}
