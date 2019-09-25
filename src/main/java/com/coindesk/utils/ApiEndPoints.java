package com.coindesk.utils;

public class ApiEndPoints {


    /**
     * Creating prefix endpoints for the convenience
     * A prefix is a group of letters placed before the root of a word
     */

    private final static String BASE_URL = "https://api.coindesk.com/v1/bpi/";
    private final static String HISTORICAL_BASE = "https://api.coindesk.com/v1/bpi/historical/close";


    public static  String getCurrentRate(String currency) {
        return BASE_URL + "currentprice/" + currency;
    }

    public static String getHistoricalRate(String currency) {
        return HISTORICAL_BASE + "?currency=" + currency;
    }




}
