package net.megogo.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Time {

    @JsonProperty("utc_offset")
    private int utcOffset;

    @JsonProperty("timestamp_local")
    private int timestampLocal;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("time_local")
    private String timeLocal;

    @JsonProperty("timestamp_gmt")
    private int timestampGmt;

    @JsonProperty("timestamp")
    private int timestamp;
}