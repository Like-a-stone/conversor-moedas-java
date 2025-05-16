package com.github.lucas.util;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonSingleton {
    private static final Gson GSON = new GsonBuilder()
            //.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    public static Gson getInstance (){
        return GSON;
    }
}
