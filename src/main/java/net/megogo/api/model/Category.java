package net.megogo.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Category{

	@JsonProperty("external_id")
	private int externalId;

	@JsonProperty("id")
	private int id;

	@JsonProperty("title")
	private String title;
}