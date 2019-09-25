package com.coindesk.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;

public class ApiService {


    /**
     * @param URL - given endpoint
     * @return openConnection - opens a connection for the URL param
     * @throws IOException - an input or output operation is failed or interpreted
     */

    public  HttpURLConnection getConnection(String URL) throws IOException {
        URL obj = new URL(URL);

        return (HttpURLConnection) obj.openConnection();
    }

    /**
     * @param inputStream Java InputStream reads data as an ordered sequence of bytes.
     * @throws IOException an input or output operation is failed or interpreted
     * {@link StringBuilder} Modifying a string without creating a new object by using a StringBuilder
     *
     * Method takes InputStream instance, then {@link BufferedReader} reads text from the character input stream.
     * Reading the data and if data is not null then placing the data into the StringBuilder instance
     */

    public String getApiResponse(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String userInputLine;
        StringBuilder response = new StringBuilder();

        while ((userInputLine = reader.readLine()) != null) {
            response.append(userInputLine);
        }

        return response.toString();
    }

    /**
     * @param conn passing existing open connection
     * @throws IOException        an input or output operation is failed or interpreted
     * @throws URISyntaxException thrown to indicate that a string could not be parsed as a URI reference
     *                            <p>
     *                            Method which logs and prints the output of the connection
     */


    public void logConnection(final HttpURLConnection conn) throws IOException, URISyntaxException {

        int code = conn.getResponseCode();
        String message = conn.getResponseMessage();
        String url = conn.getURL().toURI().toString();

        System.out.println(String.format("\nResponse from %s - Code: %d, Message: %s", url, code, message));

    }




    }

