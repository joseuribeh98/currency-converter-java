package com.conversor.service;

import com.conversor.model.Currency;
import com.conversor.model.ConversionRecord;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class CurrencyConverterService {
    private final ExchangeRateApiService apiService;
    private Map<String, Currency> currencies;
    private final List<ConversionRecord> history;

    public CurrencyConverterService() {
        this.apiService = new ExchangeRateApiService();
        this.currencies = new HashMap<>();
        this.history = new ArrayList<>();
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

        double result = amount * (toCurrency.getRate() / fromCurrency.getRate());
        
        // Agregar al historial
        history.add(new ConversionRecord(fromCode, toCode, amount, result));
        
        return result;
    }

    public List<ConversionRecord> getLastConversions(int limit) {
        int historySize = history.size();
        int startIndex = Math.max(0, historySize - limit);
        return history.subList(startIndex, historySize);
    }
}