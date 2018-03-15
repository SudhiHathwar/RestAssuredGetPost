package com.sample.test.config;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseApi {

    public URLGetter url;

    @BeforeClass
    public void init() throws IOException {

        url = new URLGetter();

        RestAssured.baseURI = url.getURLs("ÄPI");
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}