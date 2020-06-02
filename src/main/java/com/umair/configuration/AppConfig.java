package com.umair.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.umair.client.PushShiftAPIClient;
import com.umair.client.TDAmeritradeAPIClient;
import com.umair.client.ValidateStockSymbolClient;

@Configuration
public class AppConfig {

	private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

	@Bean
	public RestTemplate restTemplate() {
		logger.debug("Returning bean: restTemplate");
		return new RestTemplate();
	}

	@Bean
	public PushShiftAPIClient pushShiftAPIClient() {
		logger.debug("Returning bean: pushShiftAPIClient");
		return new PushShiftAPIClient();
	}

	@Bean
	public TDAmeritradeAPIClient tdAmeritradeAPIClient() {
		logger.debug("Returning bean: tdAmeritradeAPIClient");
		return new TDAmeritradeAPIClient();
	}

	@Bean
	public ValidateStockSymbolClient validateStockSymbolClient() {
		logger.debug("Returning bean: tdAmeritradeAPIClient");
		return new ValidateStockSymbolClient();
	}
}
