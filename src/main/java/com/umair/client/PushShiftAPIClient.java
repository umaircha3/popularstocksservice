package com.umair.client;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umair.model.RedditPostDTO;

public class PushShiftAPIClient {

	@Autowired
	RestTemplate restTemplate;

	private static final Logger logger = LoggerFactory.getLogger(PushShiftAPIClient.class);

	public List<RedditPostDTO> callPushShiftAPI(String baseURL, String subreddit, String fields, String size,
			String startDate, String endDate) {

		String url = getURI(baseURL, subreddit, fields, size, startDate, endDate);

		logger.debug("PushShift API URL IS " + url);

		List<RedditPostDTO> posts = new ArrayList<RedditPostDTO>();

		String response = restTemplate.getForObject(url, String.class);
		ObjectMapper mapper = new ObjectMapper();
		JSONObject root = null;
		try {
			root = new JSONObject(response);
			JSONArray jsonArray = (JSONArray) root.getJSONArray("data");
			for (int i = 0; i < jsonArray.length(); i++) {
				RedditPostDTO redditPostDTO = mapper.readValue(jsonArray.get(i).toString(), RedditPostDTO.class);
				posts.add(redditPostDTO);
			}
		} catch (JSONException e) {
			logger.error("JSONException: " + e.getMessage());
		} catch (JsonMappingException e) {
			logger.error("JsonMappingException: " + e.getMessage());
		} catch (JsonProcessingException e) {
			logger.error("JsonProcessingException: " + e.getMessage());
		}

		logger.debug("SIZE OF RESPONSE IS: " + posts.size());
		return posts;

	}

	public String getURI(String baseURL, String subreddit, String fields, String size, String startDate,
			String endDate) {
		UriComponents uri = UriComponentsBuilder.fromUriString(baseURL).queryParam("subreddit", subreddit)
				.queryParam("fields", fields).queryParam("size", size).queryParam("after", startDate)
				.queryParam("before", endDate).queryParam("sort", "desc").build();
		return uri.toUriString();

	}
}
