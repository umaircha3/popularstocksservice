package com.umair.client;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umair.model.QuoteDTO;

public class TDAmeritradeAPIClient {

	@Autowired
	RestTemplate restTemplate;

	@Value("${tdameritrade.api.url}")
	String apiUrl;

	@Value("${tdameritrade.api.key}")
	String apikey;

	private static final Logger logger = LoggerFactory.getLogger(TDAmeritradeAPIClient.class);

	public QuoteDTO callTDAmeritradeQuotes(String symbol) {

		String url = getURI(symbol);
		String response = restTemplate.getForObject(url, String.class);

		JSONObject object;
		QuoteDTO quote = null;
		try {
			object = new JSONObject(response);
			String[] keys = JSONObject.getNames(object);

			for (String key : keys) {
				String value = object.get(key).toString();

				ObjectMapper mapper = new ObjectMapper();
				quote = mapper.readValue(value, QuoteDTO.class);
				logger.debug("QUOTE STRING IS: " + value);

			}

			logger.debug("TD Ameritrade API URL IS: " + url);
			logger.debug("TD Ameritrade RESPONSE IS: " + response);

		} catch (NullPointerException e) {
			logger.error("No response retrieved from service for symbol: " + symbol + ". Symbol is likely invalid.");
			return null;
		} catch (JSONException e) {
			logger.error("JSONException: " + e.getMessage());
			return null;
		} catch (JsonMappingException e) {
			logger.error("JsonMappingException: " + e.getMessage());
			return null;
		} catch (JsonProcessingException e) {
			logger.error("JsonProcessingException: " + e.getMessage());
			return null;
		}

		return quote;

	}

	public String getURI(String symbol) {

		logger.debug("TD Ameritrade BASE API URL IS: " + apiUrl);
		logger.debug("TD Ameritrade API KEY IS: " + apikey);

		Map<String, String> params = new HashMap<String, String>();
		params.put("symbol", symbol);

		URI uri = UriComponentsBuilder.fromUriString(apiUrl).buildAndExpand(params).toUri();
		uri = UriComponentsBuilder.fromUri(uri).queryParam("apikey", apikey).build().toUri();
		return uri.toString();

	}

}
