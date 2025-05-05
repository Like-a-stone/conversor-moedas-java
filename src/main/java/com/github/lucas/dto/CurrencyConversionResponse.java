package com.github.lucas.dto;
// Permite extrair apenas informações necessárias para a conversão de moedas
public record CurrencyConversionResponse(
        String time_last_update_utc,
        String base_code,
        String target_code,
        double conversion_rate,
        double conversion_result
) {}
