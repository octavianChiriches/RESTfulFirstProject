package com.psrestassured;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class _10OjectMappingDemo {

    public static final String BASE_URL = "https://api.github.com/users/rest-assured";

    @Test
    public void objectMappingTestOne() {

        _9User user = RestAssured.get(BASE_URL).as(_9User.class);

        assertEquals(user.getLogin(), "rest-assured");
        assertEquals(user.getId(), 19369327);
    }
}
