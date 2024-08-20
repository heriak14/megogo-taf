package net.megogo.api.facade;

import io.qameta.allure.Step;
import io.restassured.common.mapper.TypeRef;
import java.util.List;
import net.megogo.api.client.ChannelClient;
import net.megogo.api.model.Channel;
import net.megogo.api.model.Program;
import net.megogo.api.model.ResponseContainer;

public class ChannelFacade {

    private final ChannelClient channelClient;

    public ChannelFacade() {
        channelClient = new ChannelClient();
    }

    @Step("GET channel programs by video id: {videoId}")
    public List<Program> getChannelPrograms(int videoId) {
        ResponseContainer<List<Channel>> channelResponse = channelClient.getChannelsInfoByIds(List.of(videoId)).then()
                .statusCode(200)
                .extract().response().as(new TypeRef<ResponseContainer<List<Channel>>>() {
                });
        return channelResponse.getData().getFirst().getPrograms();
    }
}
