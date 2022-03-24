package com.psrestassured;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class _6ValidatableNestedBodyDemo {

    public static final String BASE_URL = "https://api.github.com/";

    @Test
    public void nestedBodyValidationUsingDuplicates() {
        RestAssured.get(BASE_URL + "rate_limit")
                .then()
                .body("resources.core.limit", equalTo(60))
                .body("resources.core.remaining", lessThanOrEqualTo(60))
                .body("resources.core.reset", notNullValue());
    }

    @Test
    public void nestedBodyValidationUsingRootPath() {
        RestAssured.get(BASE_URL + "/rate_limit")
                .then()
                .rootPath("resources.core")
                    .body("limit", equalTo(60))
                    .body("remaining", lessThanOrEqualTo(60))
                    .body("reset", notNullValue())
                .rootPath("resources.search")
                    .body("limit", equalTo(10))
                    .body("remaining", lessThanOrEqualTo(10));
    }



}
