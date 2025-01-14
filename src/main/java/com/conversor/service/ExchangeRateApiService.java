package com.conversor.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class ExchangeRateApiService {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/USD";
    private final OkHttpClient client;
    private final Gson gson;

    public ExchangeRateApiService() {
        this.client = new OkHttpClient();
        this.gson = new Gson();
    }

    public JsonObject getExchangeRates() throws IOException {
        Request request = new Request.Builder()
            .url(API_URL)
            .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response " + response);
            }
            
            String jsonData = response.body().string();
            return gson.fromJson(jsonData, JsonObject.class);
        }
    }
}