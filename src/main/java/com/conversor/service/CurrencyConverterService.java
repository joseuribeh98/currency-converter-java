package com.conversor.service;

import com.conversor.model.Currency;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverterService {
    private final ExchangeRateApiService apiService;
    private Map<String, Currency> currencies;

    public CurrencyConverterService() {
        this.apiService = new ExchangeRateApiService();
        this.currencies = new HashMap<>();
    }

    public void fetchExchangeRates() throws IOException {
        JsonObject rates = apiService.getExchangeRates();
        JsonObject ratesObject = rates.getAsJsonObject("rates");
        
        for (String code : ratesObject.keySet()) {
            double rate = ratesObject.get(code).getAsDouble();
            currencies.put(code, new Currency(code, code, rate));
        }
    }

    public double convert(String fromCode, String toCode, double amount) {
        Currency fromCurrency = currencies.get(fromCode);
        Currency toCurrency = currencies.get(toCode);
        
        if (fromCurrency == null || toCurrency == null) {
            throw new IllegalArgumentException("Moneda no encontrada");
        }

        // Conversión usando USD como base
        return amount * (toCurrency.getRate() / fromCurrency.getRate());
    }

    public Map<String, Currency> getCurrencies() {
        return currencies;
    }
}