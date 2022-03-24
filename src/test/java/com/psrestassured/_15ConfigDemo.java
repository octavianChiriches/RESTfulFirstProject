package com.psrestassured;

import io.restassured.RestAssured;
import io.restassured.config.FailureConfig;
import io.restassured.config.RedirectConfig;
import io.restassured.listener.ResponseValidationFailureListener;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.config.FailureConfig.failureConfig;
import static io.restassured.config.RedirectConfig.redirectConfig;
import static org.hamcrest.Matchers.equalTo;

public class _15ConfigDemo {

    public static final String BASE_URL = "https://api.github.com/";

    @Test
    public void maxRedirectsTest() {

        RestAssured.config = RestAssured.config().redirect(redirectConfig().followRedirects(true).maxRedirects(1));

        RestAssured.get(BASE_URL + "repos/twitter/bootstrap")
                .then()
                .statusCode(equalTo(200));
    }

    @Test
    public void failureConfigExample() {

        ResponseValidationFailureListener failureListener = (reqSpec, resSpec, response) ->
                System.out.printf("We have a failure, " + "response status was %s and the body contained: %s", response.getStatusCode(), response.body().asPrettyString());

        RestAssured.config = RestAssured.config().failureConfig(failureConfig().failureListeners(failureListener));

        RestAssured.get(BASE_URL + "users/andrejs-ps")
                .then()
                .body("some.path", Matchers.equalTo("a thing"));
    }

    @BeforeSuite
    void setup() {
        RestAssured.config = getDefaultConfig();
    }

    @Test
    public void cleanTestWithHiddenConfig() {
        _9User user = RestAssured.get("https://api.github.com/users/rest-assured")
                .as(_9User.class);
    }


}
