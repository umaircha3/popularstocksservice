package com.umair.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "assetType", "assetMainType", "cusip", "symbol", "description", "bidPrice", "bidSize", "bidId",
		"askPrice", "askSize", "askId", "lastPrice", "lastSize", "lastId", "openPrice", "highPrice", "lowPrice",
		"bidTick", "closePrice", "netChange", "totalVolume", "quoteTimeInLong", "tradeTimeInLong", "mark", "exchange",
		"exchangeName", "marginable", "shortable", "volatility", "digits", "52WkHigh", "52WkLow", "nAV", "peRatio",
		"divAmount", "divYield", "divDate", "securityStatus", "regularMarketLastPrice", "regularMarketLastSize",
		"regularMarketNetChange", "regularMarketTradeTimeInLong", "netPercentChangeInDouble", "markChangeInDouble",
		"markPercentChangeInDouble", "regularMarketPercentChangeInDouble", "delayed" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteDTO {

	@JsonProperty("assetType")
	private String assetType;
	@JsonProperty("assetMainType")
	private String assetMainType;
	@JsonProperty("cusip")
	private String cusip;
	@JsonProperty("symbol")
	private String symbol;
	@JsonProperty("description")
	private String description;
	@JsonProperty("bidPrice")
	private Double bidPrice;
	@JsonProperty("bidSize")
	private Integer bidSize;
	@JsonProperty("bidId")
	private String bidId;
	@JsonProperty("askPrice")
	private Double askPrice;
	@JsonProperty("askSize")
	private Integer askSize;
	@JsonProperty("askId")
	private String askId;
	@JsonProperty("lastPrice")
	private Double lastPrice;
	@JsonProperty("lastSize")
	private Integer lastSize;
	@JsonProperty("lastId")
	private String lastId;
	@JsonProperty("openPrice")
	private Double openPrice;
	@JsonProperty("highPrice")
	private Double highPrice;
	@JsonProperty("lowPrice")
	private Double lowPrice;
	@JsonProperty("bidTick")
	private String bidTick;
	@JsonProperty("closePrice")
	private Double closePrice;
	@JsonProperty("netChange")
	private Double netChange;
	@JsonProperty("totalVolume")
	private Integer totalVolume;
	@JsonProperty("quoteTimeInLong")
	private Long quoteTimeInLong;
	@JsonProperty("tradeTimeInLong")
	private Long tradeTimeInLong;
	@JsonProperty("mark")
	private Double mark;
	@JsonProperty("exchange")
	private String exchange;
	@JsonProperty("exchangeName")
	private String exchangeName;
	@JsonProperty("marginable")
	private Boolean marginable;
	@JsonProperty("shortable")
	private Boolean shortable;
	@JsonProperty("volatility")
	private Double volatility;
	@JsonProperty("digits")
	private Integer digits;
	@JsonProperty("52WkHigh")
	private Double _52WkHigh;
	@JsonProperty("52WkLow")
	private Double _52WkLow;
	@JsonProperty("nAV")
	private Double nAV;
	@JsonProperty("peRatio")
	private Double peRatio;
	@JsonProperty("divAmount")
	private Double divAmount;
	@JsonProperty("divYield")
	private Double divYield;
	@JsonProperty("divDate")
	private String divDate;
	@JsonProperty("securityStatus")
	private String securityStatus;
	@JsonProperty("regularMarketLastPrice")
	private Double regularMarketLastPrice;
	@JsonProperty("regularMarketLastSize")
	private Integer regularMarketLastSize;
	@JsonProperty("regularMarketNetChange")
	private Double regularMarketNetChange;
	@JsonProperty("regularMarketTradeTimeInLong")
	private Long regularMarketTradeTimeInLong;
	@JsonProperty("netPercentChangeInDouble")
	private Double netPercentChangeInDouble;
	@JsonProperty("markChangeInDouble")
	private Double markChangeInDouble;
	@JsonProperty("markPercentChangeInDouble")
	private Double markPercentChangeInDouble;
	@JsonProperty("regularMarketPercentChangeInDouble")
	private Double regularMarketPercentChangeInDouble;
	@JsonProperty("delayed")
	private Boolean delayed;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("assetType")
	public String getAssetType() {
		return assetType;
	}

	@JsonProperty("assetType")
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	@JsonProperty("assetMainType")
	public String getAssetMainType() {
		return assetMainType;
	}

	@JsonProperty("assetMainType")
	public void setAssetMainType(String assetMainType) {
		this.assetMainType = assetMainType;
	}

	@JsonProperty("cusip")
	public String getCusip() {
		return cusip;
	}

	@JsonProperty("cusip")
	public void setCusip(String cusip) {
		this.cusip = cusip;
	}

	@JsonProperty("symbol")
	public String getSymbol() {
		return symbol;
	}

	@JsonProperty("symbol")
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("bidPrice")
	public Double getBidPrice() {
		return bidPrice;
	}

	@JsonProperty("bidPrice")
	public void setBidPrice(Double bidPrice) {
		this.bidPrice = bidPrice;
	}

	@JsonProperty("bidSize")
	public Integer getBidSize() {
		return bidSize;
	}

	@JsonProperty("bidSize")
	public void setBidSize(Integer bidSize) {
		this.bidSize = bidSize;
	}

	@JsonProperty("bidId")
	public String getBidId() {
		return bidId;
	}

	@JsonProperty("bidId")
	public void setBidId(String bidId) {
		this.bidId = bidId;
	}

	@JsonProperty("askPrice")
	public Double getAskPrice() {
		return askPrice;
	}

	@JsonProperty("askPrice")
	public void setAskPrice(Double askPrice) {
		this.askPrice = askPrice;
	}

	@JsonProperty("askSize")
	public Integer getAskSize() {
		return askSize;
	}

	@JsonProperty("askSize")
	public void setAskSize(Integer askSize) {
		this.askSize = askSize;
	}

	@JsonProperty("askId")
	public String getAskId() {
		return askId;
	}

	@JsonProperty("askId")
	public void setAskId(String askId) {
		this.askId = askId;
	}

	@JsonProperty("lastPrice")
	public Double getLastPrice() {
		return lastPrice;
	}

	@JsonProperty("lastPrice")
	public void setLastPrice(Double lastPrice) {
		this.lastPrice = lastPrice;
	}

	@JsonProperty("lastSize")
	public Integer getLastSize() {
		return lastSize;
	}

	@JsonProperty("lastSize")
	public void setLastSize(Integer lastSize) {
		this.lastSize = lastSize;
	}

	@JsonProperty("lastId")
	public String getLastId() {
		return lastId;
	}

	@JsonProperty("lastId")
	public void setLastId(String lastId) {
		this.lastId = lastId;
	}

	@JsonProperty("openPrice")
	public Double getOpenPrice() {
		return openPrice;
	}

	@JsonProperty("openPrice")
	public void setOpenPrice(Double openPrice) {
		this.openPrice = openPrice;
	}

	@JsonProperty("highPrice")
	public Double getHighPrice() {
		return highPrice;
	}

	@JsonProperty("highPrice")
	public void setHighPrice(Double highPrice) {
		this.highPrice = highPrice;
	}

	@JsonProperty("lowPrice")
	public Double getLowPrice() {
		return lowPrice;
	}

	@JsonProperty("lowPrice")
	public void setLowPrice(Double lowPrice) {
		this.lowPrice = lowPrice;
	}

	@JsonProperty("bidTick")
	public String getBidTick() {
		return bidTick;
	}

	@JsonProperty("bidTick")
	public void setBidTick(String bidTick) {
		this.bidTick = bidTick;
	}

	@JsonProperty("closePrice")
	public Double getClosePrice() {
		return closePrice;
	}

	@JsonProperty("closePrice")
	public void setClosePrice(Double closePrice) {
		this.closePrice = closePrice;
	}

	@JsonProperty("netChange")
	public Double getNetChange() {
		return netChange;
	}

	@JsonProperty("netChange")
	public void setNetChange(Double netChange) {
		this.netChange = netChange;
	}

	@JsonProperty("totalVolume")
	public Integer getTotalVolume() {
		return totalVolume;
	}

	@JsonProperty("totalVolume")
	public void setTotalVolume(Integer totalVolume) {
		this.totalVolume = totalVolume;
	}

	@JsonProperty("quoteTimeInLong")
	public Long getQuoteTimeInLong() {
		return quoteTimeInLong;
	}

	@JsonProperty("quoteTimeInLong")
	public void setQuoteTimeInLong(Long quoteTimeInLong) {
		this.quoteTimeInLong = quoteTimeInLong;
	}

	@JsonProperty("tradeTimeInLong")
	public Long getTradeTimeInLong() {
		return tradeTimeInLong;
	}

	@JsonProperty("tradeTimeInLong")
	public void setTradeTimeInLong(Long tradeTimeInLong) {
		this.tradeTimeInLong = tradeTimeInLong;
	}

	@JsonProperty("mark")
	public Double getMark() {
		return mark;
	}

	@JsonProperty("mark")
	public void setMark(Double mark) {
		this.mark = mark;
	}

	@JsonProperty("exchange")
	public String getExchange() {
		return exchange;
	}

	@JsonProperty("exchange")
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	@JsonProperty("exchangeName")
	public String getExchangeName() {
		return exchangeName;
	}

	@JsonProperty("exchangeName")
	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	@JsonProperty("marginable")
	public Boolean getMarginable() {
		return marginable;
	}

	@JsonProperty("marginable")
	public void setMarginable(Boolean marginable) {
		this.marginable = marginable;
	}

	@JsonProperty("shortable")
	public Boolean getShortable() {
		return shortable;
	}

	@JsonProperty("shortable")
	public void setShortable(Boolean shortable) {
		this.shortable = shortable;
	}

	@JsonProperty("volatility")
	public Double getVolatility() {
		return volatility;
	}

	@JsonProperty("volatility")
	public void setVolatility(Double volatility) {
		this.volatility = volatility;
	}

	@JsonProperty("digits")
	public Integer getDigits() {
		return digits;
	}

	@JsonProperty("digits")
	public void setDigits(Integer digits) {
		this.digits = digits;
	}

	@JsonProperty("52WkHigh")
	public Double get52WkHigh() {
		return _52WkHigh;
	}

	@JsonProperty("52WkHigh")
	public void set52WkHigh(Double _52WkHigh) {
		this._52WkHigh = _52WkHigh;
	}

	@JsonProperty("52WkLow")
	public Double get52WkLow() {
		return _52WkLow;
	}

	@JsonProperty("52WkLow")
	public void set52WkLow(Double _52WkLow) {
		this._52WkLow = _52WkLow;
	}

	@JsonProperty("nAV")
	public Double getNAV() {
		return nAV;
	}

	@JsonProperty("nAV")
	public void setNAV(Double nAV) {
		this.nAV = nAV;
	}

	@JsonProperty("peRatio")
	public Double getPeRatio() {
		return peRatio;
	}

	@JsonProperty("peRatio")
	public void setPeRatio(Double peRatio) {
		this.peRatio = peRatio;
	}

	@JsonProperty("divAmount")
	public Double getDivAmount() {
		return divAmount;
	}

	@JsonProperty("divAmount")
	public void setDivAmount(Double divAmount) {
		this.divAmount = divAmount;
	}

	@JsonProperty("divYield")
	public Double getDivYield() {
		return divYield;
	}

	@JsonProperty("divYield")
	public void setDivYield(Double divYield) {
		this.divYield = divYield;
	}

	@JsonProperty("divDate")
	public String getDivDate() {
		return divDate;
	}

	@JsonProperty("divDate")
	public void setDivDate(String divDate) {
		this.divDate = divDate;
	}

	@JsonProperty("securityStatus")
	public String getSecurityStatus() {
		return securityStatus;
	}

	@JsonProperty("securityStatus")
	public void setSecurityStatus(String securityStatus) {
		this.securityStatus = securityStatus;
	}

	@JsonProperty("regularMarketLastPrice")
	public Double getRegularMarketLastPrice() {
		return regularMarketLastPrice;
	}

	@JsonProperty("regularMarketLastPrice")
	public void setRegularMarketLastPrice(Double regularMarketLastPrice) {
		this.regularMarketLastPrice = regularMarketLastPrice;
	}

	@JsonProperty("regularMarketLastSize")
	public Integer getRegularMarketLastSize() {
		return regularMarketLastSize;
	}

	@JsonProperty("regularMarketLastSize")
	public void setRegularMarketLastSize(Integer regularMarketLastSize) {
		this.regularMarketLastSize = regularMarketLastSize;
	}

	@JsonProperty("regularMarketNetChange")
	public Double getRegularMarketNetChange() {
		return regularMarketNetChange;
	}

	@JsonProperty("regularMarketNetChange")
	public void setRegularMarketNetChange(Double regularMarketNetChange) {
		this.regularMarketNetChange = regularMarketNetChange;
	}

	@JsonProperty("regularMarketTradeTimeInLong")
	public Long getRegularMarketTradeTimeInLong() {
		return regularMarketTradeTimeInLong;
	}

	@JsonProperty("regularMarketTradeTimeInLong")
	public void setRegularMarketTradeTimeInLong(Long regularMarketTradeTimeInLong) {
		this.regularMarketTradeTimeInLong = regularMarketTradeTimeInLong;
	}

	@JsonProperty("netPercentChangeInDouble")
	public Double getNetPercentChangeInDouble() {
		return netPercentChangeInDouble;
	}

	@JsonProperty("netPercentChangeInDouble")
	public void setNetPercentChangeInDouble(Double netPercentChangeInDouble) {
		this.netPercentChangeInDouble = netPercentChangeInDouble;
	}

	@JsonProperty("markChangeInDouble")
	public Double getMarkChangeInDouble() {
		return markChangeInDouble;
	}

	@JsonProperty("markChangeInDouble")
	public void setMarkChangeInDouble(Double markChangeInDouble) {
		this.markChangeInDouble = markChangeInDouble;
	}

	@JsonProperty("markPercentChangeInDouble")
	public Double getMarkPercentChangeInDouble() {
		return markPercentChangeInDouble;
	}

	@JsonProperty("markPercentChangeInDouble")
	public void setMarkPercentChangeInDouble(Double markPercentChangeInDouble) {
		this.markPercentChangeInDouble = markPercentChangeInDouble;
	}

	@JsonProperty("regularMarketPercentChangeInDouble")
	public Double getRegularMarketPercentChangeInDouble() {
		return regularMarketPercentChangeInDouble;
	}

	@JsonProperty("regularMarketPercentChangeInDouble")
	public void setRegularMarketPercentChangeInDouble(Double regularMarketPercentChangeInDouble) {
		this.regularMarketPercentChangeInDouble = regularMarketPercentChangeInDouble;
	}

	@JsonProperty("delayed")
	public Boolean getDelayed() {
		return delayed;
	}

	@JsonProperty("delayed")
	public void setDelayed(Boolean delayed) {
		this.delayed = delayed;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}

