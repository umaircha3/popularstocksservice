package com.umair.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umair.client.TDAmeritradeAPIClient;
import com.umair.model.QuoteDTO;

@Service
public class ValidateStockSymbolService {

	@Autowired
	TDAmeritradeAPIClient tdAmeritradeAPIClient;

	private static final Logger logger = LoggerFactory.getLogger(ValidateStockSymbolService.class);

	public Boolean validateSymbol(String symbol) {
		
		QuoteDTO quote= tdAmeritradeAPIClient.callTDAmeritradeQuotes(symbol);

		//check quote object to see that it has values
		//if it does then return true otherwise false
		if(quote != null && quote.getSymbol() != null && quote.getDescription() != null) {
			logger.debug("Valid symbol has been passed in");
			logger.debug("QUOTE FROM TD API: " + quote.toString());
			return true;
		} else {
			logger.debug("Invalid symbol has been passed in");
			return false;
		}
	}

}
