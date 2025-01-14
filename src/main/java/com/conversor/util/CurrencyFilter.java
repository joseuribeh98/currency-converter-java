package com.conversor.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CurrencyFilter {
    private static final Set<String> COMMON_CURRENCIES = new HashSet<>(Arrays.asList(
        "USD", // Dólar estadounidense
        "EUR", // Euro
        "GBP", // Libra esterlina
        "JPY", // Yen japonés
        "BRL", // Real brasileño
        "ARS", // Peso argentino
        "CLP", // Peso chileno
        "MXN", // Peso mexicano
        "PEN", // Sol peruano
        "COP"  // Peso colombiano
    ));

    public static boolean isCommonCurrency(String currencyCode) {
        return COMMON_CURRENCIES.contains(currencyCode.toUpperCase());
    }

    public static Set<String> getCommonCurrencies() {
        return COMMON_CURRENCIES;
    }
}