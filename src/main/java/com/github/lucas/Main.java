package com.github.lucas;

import com.github.lucas.client.ClientAPI;
import com.github.lucas.dto.CurrencyConversionResponse;
import com.github.lucas.dto.ExchangeRateResponse;
import com.github.lucas.model.CurrencyConversion;

import java.math.BigDecimal;

public class Main {
    public static void main (String [] args) {
        CurrencyConversion currencyConversion = new CurrencyConversion();
        CurrencyConversionResponse teste = currencyConversion.convertCurrency("EUR","BRL", BigDecimal.valueOf(1));
        System.out.println(teste.toString());

    }
}
