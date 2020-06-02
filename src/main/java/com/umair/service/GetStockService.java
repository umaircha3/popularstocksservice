package com.umair.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.umair.client.PushShiftAPIClient;
import com.umair.client.ValidateStockSymbolClient;
import com.umair.model.DateRanges;
import com.umair.model.RedditPostDTO;
import com.umair.model.SubReddit;

@Service
public class GetStockService {

	@Autowired
	PushShiftAPIClient pushShiftAPIClient;
	@Autowired
	ValidateStockSymbolClient validateStockSymbolClient;

	@Value("${pushshift.basesubmissionURL}")
	String baseSubmissionURL;
	@Value("${pushshift.size}")
	String size;

	private static final Logger logger = LoggerFactory.getLogger(GetStockService.class);

	private static HashMap<String, Integer> invalidSymbolsMap = new HashMap<String, Integer>();
	private static HashMap<String, Integer> validSymbolsMap = new HashMap<String, Integer>();

	public Map<String, Integer> getStockTitleCountMap(DateRanges dateRange, SubReddit subreddit) {

		long startTime = System.currentTimeMillis();
		
		String selectedSubreddit = subreddit.toString();
		String startDate = getStartDate(dateRange.toString());
		System.out.println("startDate is: " +startDate);
		String endDate = getEndDate();
		String pushShiftFields = "title,created_utc";

		logger.debug("Subreddit is: " + selectedSubreddit);
		logger.debug("Fields passed in is: " + pushShiftFields);
		logger.debug("Start Date passed in is: " + startDate);
		logger.debug("End Date passed in is: " + endDate);

		List<RedditPostDTO> posts = pushShiftAPIClient.callPushShiftAPI(baseSubmissionURL, selectedSubreddit, pushShiftFields,
				size, startDate, endDate);

		Pattern pattern = Pattern.compile("$?[A-Z]{3,4}");
		Map<String, Integer> stockFrequencyMap = new HashMap<String, Integer>();
		int countofCalls = 0;
		System.out.println("Invalid map before looping is:" + invalidSymbolsMap.toString());
		System.out.println("Valid map before looping is:" + validSymbolsMap.toString());

		for (int i = 0; i < posts.size(); i++) {
			Matcher matcher = pattern.matcher(posts.get(i).getTitle());
			while (matcher.find()) {

				String currentSymbol = matcher.group();

				// check if we already know symbol is invalid
				// if not check if we already know its valid
				// otherwise make call and find out
				if (invalidSymbolsMap.containsKey(currentSymbol)) {
					// System.out.println("Invalid symbol: " + currentSymbol + " already in map.");
					invalidSymbolsMap.put(currentSymbol, 0);
				} else if (validSymbolsMap.containsKey(currentSymbol)) {
					// System.out.println("Valid symbol map contains: " + currentSymbol + " already in map.");
					if (stockFrequencyMap.containsKey(currentSymbol)) {
						stockFrequencyMap.put(currentSymbol, stockFrequencyMap.get(currentSymbol) + 1);
					} else {
						stockFrequencyMap.put(currentSymbol, 1);
					}
				} else {
					boolean symbolIsValid = validateStockSymbolClient.callValidation(currentSymbol);
					countofCalls++;
					if (symbolIsValid) {
						stockFrequencyMap.put(currentSymbol, 1);
						validSymbolsMap.put(currentSymbol, 1);
						logger.debug("Valid symbol putting in map: " + currentSymbol);
					} else {
						invalidSymbolsMap.put(currentSymbol, 1);
						System.out.println("Invalid symbol: " + currentSymbol + " being added to map.");
						logger.debug("Invalid symbol skipping: " + currentSymbol);
					}

				}

			}
		}

		stockFrequencyMap = sortMap(stockFrequencyMap);

		logger.debug("MAP of INVALID SYMBOLS" + invalidSymbolsMap.toString());
		logger.debug("MAP of KEYS WITH COUNT" + stockFrequencyMap.toString());

		System.out.println("MAP of INVALID SYMBOLS" + invalidSymbolsMap.toString());
		System.out.println("MAP of KEYS WITH COUNT" + stockFrequencyMap.toString());
		System.out.println("Total calls made: " + countofCalls);

		long endTime = System.currentTimeMillis();
		System.out.println("Response time: " + (endTime - startTime));
		return stockFrequencyMap;

	}

	// function to sort hashmap by values
	public static HashMap<String, Integer> sortMap(Map<String, Integer> stockFrequencyMap) {
		// Create a list from elements of HashMap
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(
				stockFrequencyMap.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o2, Map.Entry<String, Integer> o1) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		// put data from sorted list to hashmap
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

	private String getEndDate() {
		// we want date range to always be the end of the current day
		// return today plus one day
		DateTime today = new DateTime().withTimeAtStartOfDay();
		DateTime tomorrow = today.plusDays(1).withTimeAtStartOfDay();
		String epochTime = Long.toString(tomorrow.getMillis() / 1000);
		return epochTime;

	}

	private String getStartDate(String dateRange) {
		DateTime today = new DateTime().withTimeAtStartOfDay();
		DateTime now = DateTime.now();
		String epochTime = null;
		logger.debug("date range value is inside startdate:" + dateRange);

		if(dateRange.contains("Hour")) {
			System.out.println("DateRange passed to switch is: " + dateRange);

			
			switch (dateRange) {
			
			case "OneHour":
				System.out.println("DateRange Hour is1: " + dateRange);
				DateTime oneHour = now.minusHours(1);
				epochTime = Long.toString(oneHour.getMillis() / 1000);
				return epochTime;
			case "ThreeHours":
				System.out.println("DateRange Hour is3: " + dateRange);
				DateTime threeHours = now.minusHours(3);
				epochTime = Long.toString(threeHours.getMillis() / 1000);
				return epochTime;
			case "FiveHours":
				System.out.println("DateRange Hour is5: " + dateRange);
				DateTime fiveHours = now.minusHours(5);
				epochTime = Long.toString(fiveHours.getMillis() / 1000);
				return epochTime;
			case "TwelveHours":
				System.out.println("DateRange Hour is6: " + dateRange);
				DateTime twelveHours = now.minusHours(12);
				epochTime = Long.toString(twelveHours.getMillis() / 1000);
				return epochTime;
			case "TwentyFourHours":
				System.out.println("DateRange Hour is7: " + dateRange);
				DateTime twentyFourHours = now.minusHours(24);
				epochTime = Long.toString(twentyFourHours.getMillis() / 1000);	
				return epochTime;
			default:
				System.out.println("Incorrect Epoch time is: " + epochTime);
				
			}
		}
		if (dateRange.equalsIgnoreCase("today")) {
			epochTime = Long.toString(today.getMillis() / 1000);
			return epochTime;
		} else if (dateRange.equalsIgnoreCase("week")) {
			DateTime lastWeek = today.minusDays(7).withTimeAtStartOfDay();
			epochTime = Long.toString(lastWeek.getMillis() / 1000);
			return epochTime;
		} else if (dateRange.equalsIgnoreCase("month")) {
			DateTime lastMonth = today.minusDays(30).withTimeAtStartOfDay();
			epochTime = Long.toString(lastMonth.getMillis() / 1000);
			return epochTime;
		} else {
			return null;
		}
	}

	@EventListener(ApplicationReadyEvent.class)
	public void getSymbolsOnStartUp(){
		//this class will get data from both pennystocks and wsb subreddits for last 24 HRS and populate the valid and invalid maps
		System.out.println("System startup loading map from pennystocks: ");
		getStockTitleCountMap(DateRanges.Today, SubReddit.pennystocks);
		System.out.println("System startup loading map from wallstreetbets: ");
		getStockTitleCountMap(DateRanges.Today, SubReddit.wallstreetbets);


	}
	
}
