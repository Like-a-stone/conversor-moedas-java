package com.github.lucas.model;

import com.github.lucas.client.ClientAPI;
import com.github.lucas.dto.CurrencyConversionResponse;
import com.github.lucas.dto.ExchangeRateResponse;
import java.math.BigDecimal;

public class CurrencyConversion {
    private ClientAPI clientAPI = new ClientAPI();

    public CurrencyConversionResponse convertCurrency(CurrencyEnum base, CurrencyEnum target, BigDecimal amount) {
        ExchangeRateResponse exchangeRateResponse = callAPI(base, target);

        BigDecimal result = amount.multiply(BigDecimal.valueOf(exchangeRateResponse.conversion_rate()));
        return new CurrencyConversionResponse(
                exchangeRateResponse.time_last_update_utc(),
                exchangeRateResponse.base_code(),
                exchangeRateResponse.target_code(),
                exchangeRateResponse.conversion_rate(),
                result.doubleValue()
        );
    }

    private ExchangeRateResponse callAPI(CurrencyEnum base, CurrencyEnum target) {
        return clientAPI.pairConversion(base, target);
    }
}
