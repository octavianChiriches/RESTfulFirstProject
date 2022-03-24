package com.psrestassured;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.time.format.ResolverStyle;


public class _13OtherMethodsDemo {

    public static final String BASE_URL = "https://api.github.com/user/repos";
    public static final String TOKEN = "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";

    @Test(description = "Create a repo")
    public void postTest() {

        RestAssured
                .given()
                    .header("Authorization", "token " + TOKEN)
                    .body("{\"name\": \"deleteme\"}")
                .when()
                    .post(BASE_URL)
                .then()
                    .statusCode(201);
    }

    @Test(description = "Update a repo")
    public void patchTest() {

        RestAssured
                .given()
                    .header("Authorization", "token " + TOKEN)
                    .body("{\"name\": \"deleteme-patched\"}")
                .when()
                    .patch("https://api.github.com/repos/octavianChiriches/deleteme")
                .then()
                    .statusCode(200);
    }

    @Test(description = "Update a repo")
    public void deleteTest() {

        RestAssured
                .given()
                    .header("Authorization", "token " + TOKEN)
                    .body("{\"name\": \"deleteme-patched\"}")
                .when()
                    .delete("https://api.github.com/repos/octavianChiriches/deleteme-patched")
                .then()
                    .statusCode(204);
    }
}
