package com.github.lucas.config;


import io.github.cdimascio.dotenv.Dotenv;

public class EnvConfig {
    private static final Dotenv dotenv = Dotenv.configure().load();

    public static String getApiKey() {
        return dotenv.get("API_KEY");
    }
}