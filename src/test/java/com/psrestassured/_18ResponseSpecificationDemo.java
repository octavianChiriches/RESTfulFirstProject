package com.psrestassured;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _18ResponseSpecificationDemo {

    public static final String BASE_URL = "HTTPS://api.github.com/";

    @BeforeClass
    public void setup() {
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(404)
                .expectContentType(ContentType.JSON)
                .build();
    }

    @AfterClass
    public void cleanUp() {
        RestAssured.responseSpecification = null;
    }

    ResponseSpecification commonResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(404)
            .expectContentType(ContentType.JSON)
            .build();


    @Test
    public void testWithSpecOne() {

        RestAssured.get(BASE_URL + "non/existing/url")
                .then()
                .spec(commonResponseSpec);
        // + more custom verifications;
    }

    @Test
    public void testWithSpecTwo() {
        RestAssured.get(BASE_URL + "non/existing/url")
                .then()
                .statusCode(404)
                .contentType(ContentType.JSON);
        // + more custom verifications;
    }
}
