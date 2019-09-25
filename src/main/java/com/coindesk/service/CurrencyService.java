package com.coindesk.service;

import com.coindesk.utils.ObjectMapperProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.coindesk.model.CoinDeskResponse;
import com.coindesk.model.HistoricalResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;



public class CurrencyService {

    private static ObjectMapper mapper = ObjectMapperProvider.get();
    private  CoinDeskApiService apiService = new CoinDeskApiService();


    /**
     * @param currency - passing currency value in order to get the required external data
     * @throws IOException an input or output operation is failed or interpreted
     *                     <p>
     *                     ObjectMapper class ObjectMapper provides functionality for reading and writing JSON
     *                     writerWithDefaultPrettyPrinter() - method from ObjectMapper class that makes JSON looks pretty
     *                     <p>
     *                     Method returns data from the provided api endpoint and maps it to the already created CoinDeskResponse POJO class
     */


    public  void displayCurrencyData(String currency) throws IOException, URISyntaxException {
        CoinDeskResponse response = apiService.getForCurrency(currency);
        String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response.getBpi().get(currency.toUpperCase()));
        String timeResponse = mapper.writeValueAsString(response.getTime());
        System.out.println(timeResponse);
        System.out.println(prettyJson);
    }


    public void displayCurrencyHistoricalData(String currency) throws IOException, URISyntaxException {

        HistoricalResponse response = apiService.getHistoricalResponse(currency);

        System.out.println("The highest Bitcoin rate in the last 30 days, in the requested currency happened on "
                + getMaxRate(response).getKey()
                + " and was "
                + getMaxRate(response).getValue());

        System.out.println("The lowest Bitcoin rate in the last 30 days, in the requested currency happened on"
                + getMinRate(response).getKey()
                + " and was "
                + getMinRate(response).getValue());

    }

    /**
     * Response from the Historical call will go as an argument to the getMax and getMin methods in order to get biggest/smallest value
     *
     * @return a comparator that compares {@link Map.Entry} in natural order on value.
     * @see Comparable
     * @see Collections
     */

    public Map.Entry<LocalDate, BigDecimal> getMaxRate(HistoricalResponse response) {
        return Collections.max(response.getBpi().entrySet(), Map.Entry.comparingByValue());
    }

    public  Map.Entry<LocalDate, BigDecimal> getMinRate(HistoricalResponse response) {
        return Collections.min(response.getBpi().entrySet(), Map.Entry.comparingByValue());
    }





}
