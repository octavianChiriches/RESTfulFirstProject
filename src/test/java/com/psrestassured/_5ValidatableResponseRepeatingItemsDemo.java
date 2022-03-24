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
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class _5ValidatableResponseRepeatingItemsDemo {

    public static final String BASE_URL = "https://reqres.in/api/users/";

    @Test
    public void peakHttpbin() {
        RestAssured.get(BASE_URL)
                .prettyPeek();
    }

    @Test
    public void repeatingItems() {
        RestAssured.get(BASE_URL)
                .then()
                .body("data.id[1]", equalTo(2))
                .body("data.id[2]", equalTo(3))
                .body("data.first_name[2]", equalTo("Emma"))
                .body("data.first_name[3]", equalTo("Eve"))
                .body("data.first_name", hasItems("Eve", "Emma"))
                .body("data.first_name", hasItem(endsWith("ma")));
    }

}
