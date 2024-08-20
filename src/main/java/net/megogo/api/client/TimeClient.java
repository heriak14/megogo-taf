package net.megogo.api.client;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public class TimeClient extends BaseClient {

    private static final String TIME = "/time";

    @Step("GET current time")
    public Response getCurrentTime() {
        return getClient()
                .get(TIME);
    }
}
