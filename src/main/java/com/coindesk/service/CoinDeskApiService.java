package com.coindesk.service;

import com.coindesk.utils.ObjectMapperProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.coindesk.model.CoinDeskResponse;
import com.coindesk.model.HistoricalResponse;
import com.coindesk.utils.ApiEndPoints;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;


public class CoinDeskApiService {

    /**
     * Calling the ObjectMapper Singleton instance and created each instance of my services in order to access their methods.
     */

    private static ObjectMapper mapper = ObjectMapperProvider.get();
    private static ApiService apiService = new ApiService();


    /**
     *
     *
     * @param currency passing currency
     * @return returning response and letting ObjectMapper to deal with mapping
     * @throws IOException an input or output operation is failed or interpreted
     * @throws URISyntaxException Checked exception thrown to indicate that a string could not be parsed as a URI reference
     */


    public CoinDeskResponse getForCurrency(String currency) throws IOException, URISyntaxException {

        String url = ApiEndPoints.getCurrentRate(currency);
        HttpURLConnection conn = apiService.getConnection(url);
        apiService.logConnection(conn);
        String response = apiService.getApiResponse(conn.getInputStream());
        return mapper.readValue(response, CoinDeskResponse.class);
    }


    public HistoricalResponse getHistoricalResponse(String currency) throws IOException, URISyntaxException {

        String url = ApiEndPoints.getHistoricalRate(currency);
        HttpURLConnection conn = apiService.getConnection(url);
        apiService.logConnection(conn);
        String response = apiService.getApiResponse(conn.getInputStream());


        return mapper.readValue(response, HistoricalResponse.class);
    }
}
