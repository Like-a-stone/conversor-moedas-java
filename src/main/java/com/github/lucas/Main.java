package com.github.lucas;

import com.github.lucas.client.ClientAPI;
import java.math.BigDecimal;

public class Main {
    public static void main (String [] args) {
        ClientAPI api = new ClientAPI();
       api.pairConversion("EUR","BRL", BigDecimal.valueOf(10));
    }
}
