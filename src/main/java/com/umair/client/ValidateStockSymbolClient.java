package com.umair.client;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class ValidateStockSymbolClient {
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${validationservice.api.url}")
	String apiUrl;
	
	private static final Logger logger = LoggerFactory.getLogger(ValidateStockSymbolClient.class);
	
	//this class will have a method to take the symbol and calls the local validatesymbol service
	public Boolean callValidation(String symbol) {
		
		
        InetAddress ip;
        String hostname;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Hostname : " + hostname);
            

 
        } catch (UnknownHostException e) {
 
            e.printStackTrace();
        }
		
		//System.out.println("PASSED IN SYMBOL to  boolean is :" + symbol);

		String url = getURI(symbol);
		
		Boolean response = restTemplate.getForObject(url, Boolean.class);

		logger.debug("REsponse from boolean is :" + response);
		try {
			TimeUnit.MILLISECONDS.sleep(350);
		} catch (InterruptedException e) {
			logger.error("InterruptedException: " + e.getMessage());
		}
		return response;
		
	}
	
	public String getURI(String symbol) {
		UriComponents uri = UriComponentsBuilder.fromUriString(apiUrl).queryParam("symbol", symbol).build();
		return uri.toUriString();

	}
	
}
