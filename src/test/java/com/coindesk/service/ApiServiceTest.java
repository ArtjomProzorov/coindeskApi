package com.coindesk.service;

import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiServiceTest {

    @Test
    public void testUrlConnection() throws Exception {

        String strUrl = "https://coindesk.com/api";

        try {
            URL url = new URL(strUrl);
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.connect();

            urlConn.setConnectTimeout(5000);

            assertEquals(HttpURLConnection.HTTP_OK, urlConn.getResponseCode());

        } catch (IOException e) {
            System.err.println("Error creating HTTP connection");
            e.printStackTrace();
            throw e;
        }
    }
}
