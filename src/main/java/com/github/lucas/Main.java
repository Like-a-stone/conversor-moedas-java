package com.github.lucas;

import com.github.lucas.client.ClientAPI;
import com.github.lucas.dto.ExchangeRateResponse;

import java.math.BigDecimal;

public class Main {
    public static void main (String [] args) {
        ClientAPI api = new ClientAPI();
        ExchangeRateResponse result = api.pairConversion("EUR","BRL", BigDecimal.valueOf(10));
        System.out.println(result.toString());
    }
}
