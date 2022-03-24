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

import static org.hamcrest.Matchers.greaterThan;
import static org.testng.Assert.*;

public class _3BasicResponseBodyDemo {

    public static final String BASE_URL = "https://api.github.com/rate_limit";

    @Test
    public void jsonPathReturnsMap() {
        Response response = RestAssured.get(BASE_URL);

        ResponseBody<?> body = response.body();
        JsonPath jPath = body.jsonPath();

        JsonPath jPath2 = response.body().jsonPath();

        Map<String, String> fullJson = jPath.get();
        Map<String, String> subMap = jPath.get("resources");
        Map<String, String> subMap2 = jPath.get("resources.core");

        int value = jPath.get("resources.core.limit");
        int value2 = jPath.get("resources.graphql.remaining");

        System.out.println(fullJson);
        System.out.println(subMap);
        System.out.println(subMap2);
        System.out.println(value);
        System.out.println(value2);

        assertEquals(value, 60);
        assertEquals(value2, 0);
    }

    @Test
    public void castingFailure() { // should fail;
        JsonPath jPath = RestAssured.get(BASE_URL).body().jsonPath();

        Map<String, String> isNull = jPath.get("incorrect.path"); // Null pointer exceptions; NPE
        int aMap = jPath.get("resources.core");                   // ClassCastException
        String value = jPath.get("resources.core.limit");         // ClassCastException
    }


}
