package com.github.lucas.client;

import com.github.lucas.dto.ExchangeRateResponse;
import com.github.lucas.util.GsonSingleton;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.github.lucas.config.EnvConfig.getApiKey;

public class ClientAPI {
    private final HttpClient client = HttpClient.newHttpClient();

    public ExchangeRateResponse pairConversion (String base, String target){
        String urlStr = settingUrl (base, target);

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlStr))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return GsonSingleton.getInstance().fromJson(response.body(), ExchangeRateResponse.class);

        }catch (IOException | InterruptedException e) {
            System.out.println("Erro ao consultar o endereço: "+ e.getMessage());
            return null;
        }
    }

    private String settingUrl (String base, String target){
        String API_KEY = getApiKey();
        return "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s"
                .formatted(API_KEY, base , target);
    }
}
