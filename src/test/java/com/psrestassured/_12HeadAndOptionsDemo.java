package com.psrestassured;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.time.format.ResolverStyle;

import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.equalTo;

public class _12HeadAndOptionsDemo {

    public static final String BASE_URL = "https://api.github.com/";

    @Test
    public void headTest() {
        RestAssured.head(BASE_URL)
                .then()
                .statusCode(200)
                .body(emptyOrNullString());
    }

    @Test
    public void optionsTest() {
        RestAssured.options(BASE_URL)
                .then()
                .statusCode(204)
                .header("access-control-allow-methods", equalTo("GET, POST, PATCH, PUT, DELETE"))
                .body(emptyOrNullString());
    }
}
