package net.megogo.api;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.restassured.common.mapper.TypeRef;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import net.megogo.api.client.TimeClient;
import net.megogo.api.model.ResponseContainer;
import net.megogo.api.model.Time;
import net.megogo.core.utils.DateTimeUtils;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class GetTimeTest {

    private final TimeClient timeClient = new TimeClient();

    @Test(description = "Verify server returns current time")
    public void testGetTime() {
        LocalDateTime timeBeforeRequest = LocalDateTime.now(ZoneOffset.UTC);
        ResponseContainer<Time> response = timeClient.getCurrentTime().then()
                .statusCode(HttpStatus.SC_OK)
                .extract().response().as(new TypeRef<ResponseContainer<Time>>() {
                });
        LocalDateTime timeAfterRequest = LocalDateTime.now(ZoneOffset.UTC);
        assertEquals(response.getResult(), "ok", "Result should be 'success'");
        Time time = response.getData();
        LocalDateTime serverTime = DateTimeUtils.getLocalDateTimeFromTimestamp(time.getTimestamp());
        boolean isTimeCorrect = serverTime.isEqual(timeBeforeRequest) ||
                (serverTime.isAfter(timeBeforeRequest) && serverTime.isBefore(timeAfterRequest));
        assertTrue(isTimeCorrect, "Server time (%s) should be between %s and %s".formatted(serverTime, timeBeforeRequest, timeAfterRequest));
    }
}
