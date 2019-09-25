package com.coindesk.service;


import com.coindesk.model.HistoricalResponse;
import org.junit.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class CurrencyServiceTest {


    private CurrencyService currencyService = new CurrencyService();




    @Test
    public void bigDecimalIsMinimumAndLocalDateIsValid() {

        Map<LocalDate, BigDecimal> bpi = new HashMap<>();
        bpi.put(LocalDate.of(2018, 10, 23), BigDecimal.valueOf(10));
        bpi.put(LocalDate.of(2018, 10, 22), BigDecimal.valueOf(20));
        bpi.put(LocalDate.of(2018, 10, 21), BigDecimal.valueOf(30));

        Map.Entry<LocalDate, BigDecimal> minRate = currencyService.getMinRate(new HistoricalResponse(bpi));
        assertEquals(LocalDate.of(2018, 10, 23), minRate.getKey());
        assertEquals(BigDecimal.valueOf(10), minRate.getValue());
    }

    @Test
    public void bigDecimalIsMaximumAndLocalDateIsValid() {

        Map<LocalDate, BigDecimal> bpi = new HashMap<>();
        bpi.put(LocalDate.of(2018, 10, 23), BigDecimal.valueOf(10));
        bpi.put(LocalDate.of(2018, 10, 22), BigDecimal.valueOf(20));
        bpi.put(LocalDate.of(2018, 10, 21), BigDecimal.valueOf(30));

        Map.Entry<LocalDate, BigDecimal> maxRate = currencyService.getMaxRate(new HistoricalResponse(bpi));
        assertEquals(LocalDate.of(2018, 10, 21), maxRate.getKey());
        assertEquals(BigDecimal.valueOf(30), maxRate.getValue());
    }




}





