package com.psrestassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.number.OrderingComparison;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class _4ValidatableResponseBodyDemo {

    public static final String BASE_URL = "https://api.github.com";

    @Test
    public void matcherExample() {
        RestAssured.get(BASE_URL)
                .then()
                .body("current_user_url", equalTo(BASE_URL + "user"))
                .body(containsString("feeds_url"), containsString("current_user_url"));
    }

    @Test
    public  void complexBodyExample() {
        RestAssured.get(BASE_URL + "/users/andrejs-ps")
                .then()
                .body("url", response -> Matchers.containsString(response.body().jsonPath().get("login")));
    }

    @DataProvider
    public Object[][] names(){
            return new Object[][] {
                    {"andrejs-ps"},
                    {"rest-assured"}
            };
    }

    @Test(dataProvider = "names")
    public void complexBodyExampleWithDp (String name) {
        RestAssured.get(BASE_URL + "users/" + name)
                .then()
                .body("url", response -> Matchers.containsString(response.body().jsonPath().get("login")));
    }

}

