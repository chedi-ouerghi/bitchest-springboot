package tn.springboot.bitshest.services;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Map;

public class CryptoApiResponse {

    private String id;
    private String name;
    private String symbol;

    @JsonProperty("market_data")
    private MarketData marketData;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public MarketData getMarketData() {
        return marketData;
    }

    public void setMarketData(MarketData marketData) {
        this.marketData = marketData;
    }

    // Inner class for Market Data
    public static class MarketData {

        @JsonProperty("current_price")
        private Map<String, BigDecimal> currentPrice;

        @JsonProperty("price_change_percentage_24h")
        private Double priceChangePercentage24h;

        // Getters and Setters

        public Map<String, BigDecimal> getCurrentPrice() {
            return currentPrice;
        }

        public void setCurrentPrice(Map<String, BigDecimal> currentPrice) {
            this.currentPrice = currentPrice;
        }

        public Double getPriceChangePercentage24h() {
            return priceChangePercentage24h;
        }

        public void setPriceChangePercentage24h(Double priceChangePercentage24h) {
            this.priceChangePercentage24h = priceChangePercentage24h;
        }
    }
}
