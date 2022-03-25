package com.psrestassured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static psrestassured.ConfigFactory.getDefaultConfig;

public class _17RequestSpecificationDemo {

    public static final String BASE_URL = "HTTPS://api.github.com/";

    @Test
    public void testUsingLocalRequestSpec() {
        RestAssured
                .given()
                    .spec(getDefaultRequestSpec())
                .when()
                    .get()
                .then()
                .statusCode(200);
    }

    public static RequestSpecification getDefaultRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setConfig(getDefaultConfig())
                .build();
    }
}
