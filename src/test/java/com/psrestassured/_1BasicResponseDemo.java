package com.psrestassured;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class _1BasicResponseDemo {

    public static final String BASE_URL = "https://api.github.com";
    Response response = RestAssured.get(BASE_URL);
    Headers headers = response.getHeaders();

    @Test
    public void convenienceMethods() {

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.getContentType(), "application/json; charset=utf-8");
    }

    @Test
    public void genericHeader() {
        assertEquals(response.getHeader("server"), "GitHub.com");
        assertEquals(response.getHeader("X-RateLimit-Limit"), "60");
    }

    @Test
    public void getHeaders() {
        String val = headers.getValue("Server");
        System.out.println(val);
        int size = headers.size();
        List<Header> list = headers.asList();
        boolean isPresent = headers.hasHeaderWithName("Date");
        assertTrue(isPresent);
        System.out.println("The header with name 'Date' is present? Response: " + isPresent);
    }
}
