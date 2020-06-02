package com.umair.model;

public enum DateRanges {

	OneHour("One Hour", 1),
	ThreeHours("Three Hours", 3),
	FiveHours("Three Hours", 5),
	TwelveHours("Three Hours", 12),
	SixteenHours("Three Hours", 16),
	TwentyFourHours("Three Hours", 24),
	Today("Today", 00),
	PastTwoDays("Two Days", 00),
	PastFiveDays("Three Hours", 00),
	Week("Week", 00),
	TwoWeeks("Two Weeks", 00);

	DateRanges(String string, int i) {
	}
	
}
