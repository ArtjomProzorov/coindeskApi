package com.coindesk;


import com.coindesk.service.CurrencyService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import static com.coindesk.utils.UserInput.inputNormalize;
import static com.coindesk.utils.UserInput.validateCurrency;


public class App {


    public static void main(String[] args) {

        CurrencyService currencyService = new CurrencyService();

        try {
          BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Please input the currency you wish to know BTC rate for?");

            String currency = inputNormalize(in.readLine());
            validateCurrency(currency);



            currencyService.displayCurrencyData(currency);
            currencyService.displayCurrencyHistoricalData(currency);

            in.close();

        } catch (IOException e) {
            throw new RuntimeException("Unsupported currency");

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


    }
}

