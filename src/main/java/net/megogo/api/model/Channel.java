package net.megogo.api.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Channel {

	@JsonProperty("external_id")
	private int externalId;

	@JsonProperty("id")
	private int id;

	@JsonProperty("programs")
	private List<Program> programs;

	@JsonProperty("title")
	private String title;

	@JsonProperty("pictures")
	private Object pictures;

	@JsonProperty("video_id")
	private int videoId;
}