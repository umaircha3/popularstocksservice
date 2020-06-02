package com.umair.model;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RedditPostDTO {

	@JsonProperty("title")
	private String title;

	@JsonProperty("selftext")
	private String selftext;

	@JsonProperty("created_utc")
	private String created_utc;

	@Override
	public String toString() {
		return "RedditPostDTO [title=" + title + ", selftext=" + selftext + ", created_utc="
				+ Instant.ofEpochMilli(Long.parseLong(created_utc)) + "]";
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("selftext")
	public String getSelftext() {
		return selftext;
	}

	@JsonProperty("selftext")
	public void setSelftext(String selftext) {
		this.selftext = selftext;
	}


	@JsonProperty("created_utc")
	public String getCreated_utc() {
		return created_utc;
	}


	@JsonProperty("created_utc")
	public void setCreated_utc(String created_utc) {
		this.created_utc = created_utc;
	}

}
