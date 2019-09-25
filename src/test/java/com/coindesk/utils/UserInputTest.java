package com.coindesk.utils;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserInputTest {

    @Test
    public void inputHasBeenNormalised() {
        assertEquals("GBP", UserInput.inputNormalize("G B P"));
        assertEquals("PHP", UserInput.inputNormalize("P H   P"));

    }


    @Test
    public void exceptionThrownIfInputInvalid() {
        assertThrows(RuntimeException.class, () -> {
            UserInput.validateCurrency("hh!h") ;
        });
    }

    @Test()
    public void moreThanThreeCharactersIsNotAllowed(){
        assertThrows(RuntimeException.class, () -> {
            UserInput.validateCurrency("GBPR") ;
        });
    }


}
