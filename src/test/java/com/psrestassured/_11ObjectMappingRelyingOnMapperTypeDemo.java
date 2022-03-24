package com.psrestassured;

import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class _11ObjectMappingRelyingOnMapperTypeDemo {

    public static final String BASE_URL = "https://api.github.com/users/rest-assured";

    @Test
    public void objectMappingRelyingOnMapperType() {
        _9User user = RestAssured.get(BASE_URL)
                .as(_9User.class, ObjectMapperType.JACKSON_2);

        assertEquals(user.getLogin(), "rest-assured");
    }
}
