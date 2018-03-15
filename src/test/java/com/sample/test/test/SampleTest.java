package com.sample.test.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SampleTest {

    private Response register(){
        RequestSpecification request = given();

        Map<String, String> jsonAsMap = new HashMap<>();
        jsonAsMap.put("FirstName", "Virender");
        jsonAsMap.put("LastName", "Singh");
        jsonAsMap.put("UserName", "simpleuser001");
        jsonAsMap.put("Password", "password1");
        jsonAsMap.put("Email", "someuser@gmail.com");

        return given()
                    .contentType("application/json").accept("application/json")
                    .body(jsonAsMap)
                .when()
                    .post("/register").then().extract().response();
    }

    @Test
    public void PostTest() {

        Response response = register();
        response.then().assertThat().statusCode(201);
        Assert.assertEquals(response.path("SuccessCode"), "OPERATION_SUCCESS");
    }

    @Test
    public void GetTest()
    {
        Response response = given().when().get("http://restapi.demoqa.com/utilities/weather/city/Bangalore");
        System.out.println("Response Body is =>  " + response.getBody().asString());
    }
}

