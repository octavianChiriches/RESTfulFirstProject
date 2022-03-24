package com.psrestassured;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.internal.mapping.Jackson2Mapper;
import io.restassured.path.json.mapper.factory.Jackson2ObjectMapperFactory;
import org.testng.annotations.Test;

import java.lang.reflect.Type;

import static org.testng.AssertJUnit.assertEquals;

public class _16ObjectMappingDemo {

    public static final String BASE_URL = "https://api.github.com/";

    @Test
    public void objectMappingUsingSpecifiedMapper() {
        io.restassured.mapper.ObjectMapper mapper  = new Jackson2Mapper(new Jackson2ObjectMapperFactory() {
            @Override
            public ObjectMapper create(Type type, String s) {
                ObjectMapper om = new ObjectMapper();
                om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                return om;
            }
        });

        _9User user = RestAssured.get(BASE_URL)
                .as(_9User.class, mapper);

        assertEquals(user.login, "rest-assured");
    }

}
