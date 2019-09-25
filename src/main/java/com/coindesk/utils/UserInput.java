package com.coindesk.utils;


public class UserInput {


    /**
     * @param currency input for further validation process
     *                 If currency does not match a letter from the alphabet A-Z and the currency not exactly 3 characters
     *                 throw @{@link RuntimeException}
     */

    public static void validateCurrency(String currency) {

        if (!currency.matches("[a-zA-Z]{3}"))
            throw new RuntimeException("Wrong input, currency code should contain 3 characters");

    }


    /**
     * @param currency input currency for manipulation
     *                 Using String's method replaceAll() to remove all the occurrences of white spaces.
     */
    public static String inputNormalize(String currency) {
        return currency.replaceAll("\\s", "");
    }

}