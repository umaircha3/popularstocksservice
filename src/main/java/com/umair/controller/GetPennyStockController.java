package com.umair.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.umair.model.DateRanges;
import com.umair.model.SubReddit;
import com.umair.service.GetStockService;
import com.umair.service.ValidateStockSymbolService;

import io.micrometer.core.instrument.util.StringUtils;

@RestController
@RequestMapping("/")
public class GetPennyStockController {

	@Autowired
	GetStockService getStockService;

	@Autowired
	ValidateStockSymbolService validateStockSymbolService;

	private static final Logger logger = LoggerFactory.getLogger(GetPennyStockController.class);

	@GetMapping("/getpennystocklist")
	public Map<String, Integer> getPennyStockList(DateRanges dateRange, SubReddit subreddit) {
		logger.debug("Date range passed in is: " + dateRange.toString());
		System.out.println("Date range passed in is: " + dateRange.toString());

		return getStockService.getStockTitleCountMap(dateRange, subreddit);
	}

	@GetMapping("/validatesymbol")
	public Boolean validatesymbol(@RequestParam(name = "symbol", defaultValue = "") String symbol) {

		logger.debug("Passed in symbol is: " + symbol);

		if (StringUtils.isBlank(symbol)) {
			logger.error("Passed in empty symbol.");
			return false;
		} else {
			return validateStockSymbolService.validateSymbol(symbol);
		}
	}

}
