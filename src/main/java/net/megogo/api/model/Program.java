package net.megogo.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Program {

    @JsonProperty("schedule_type")
    private String scheduleType;

    @JsonProperty("end_timestamp")
    private int endTimestamp;

    @JsonProperty("start_timestamp")
    private int startTimestamp;

    @JsonProperty("start")
    private String start;

    @JsonProperty("external_id")
    private int externalId;

    @JsonProperty("end")
    private String end;

    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("category")
    private Category category;

    @JsonProperty("pictures")
    private Object pictures;

    @JsonProperty("virtual_object_id")
    private String virtualObjectId;
}