package com.conversor;

import com.conversor.service.CurrencyConverterService;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Inicializando Conversor de Monedas...");
        
        CurrencyConverterService converter = new CurrencyConverterService();
        
        try {
            converter.fetchExchangeRates();
            System.out.println("Tasas de cambio actualizadas correctamente");
            
            // Ejemplo de conversión
            double amount = 100.0;
            String fromCurrency = "USD";
            String toCurrency = "EUR";
            
            double result = converter.convert(fromCurrency, toCurrency, amount);
            System.out.printf("%.2f %s = %.2f %s%n", 
                amount, fromCurrency, result, toCurrency);
            
        } catch (IOException e) {
            System.err.println("Error al obtener las tasas de cambio: " + e.getMessage());
        }
    }
}