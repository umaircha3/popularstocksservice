package com.umair.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.umair.client.PushShiftAPIClient;
import com.umair.client.TDAmeritradeAPIClient;
import com.umair.client.ValidateStockSymbolClient;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class AppConfig {

	private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

	@Bean
	public OpenAPI customOpenAPI(@Value("${application-description}") String appDesciption,
			@Value("${application-version}") String appVersion) {

		return new OpenAPI()
				.info(new Info()
						.title("Spring Boot Microservice for Frequently Mentioned Tickers")
						.version(appVersion)
						.description(appDesciption)
						.termsOfService("http://swagger.io/terms/")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));

	}

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
