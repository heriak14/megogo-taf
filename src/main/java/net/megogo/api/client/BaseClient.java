package net.megogo.api.client;

import static io.restassured.RestAssured.given;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import net.megogo.core.EnvProperties;

public class BaseClient {

    private static final String BASE_URL = EnvProperties.getBaseUrl();

    protected RequestSpecification getClient() {
        return given()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new AllureRestAssured())
                .urlEncodingEnabled(false)
                .baseUri(BASE_URL);
    }
}
