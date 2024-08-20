package net.megogo.api.client;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import java.util.List;
import java.util.stream.Collectors;

public class ChannelClient extends BaseClient {

    private static final String CHANNELS = "/channel";
    private static final String VIDEO_IDS = "video_ids";

    @Step("GET Channels info by video ids: {videoIds}")
    public Response getChannelsInfoByIds(List<Integer> videoIds) {
        String videoIdsString = videoIds.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        return getClient()
                .queryParams(VIDEO_IDS, videoIdsString)
                .get(CHANNELS);
    }
}
