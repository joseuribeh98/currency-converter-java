package com.conversor;

import com.conversor.model.ConversionRecord;
import com.conversor.service.CurrencyConverterService;
import com.conversor.util.CurrencyFilter;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CurrencyConverterService converter = new CurrencyConverterService();

    public static void main(String[] args) {
        System.out.println("Inicializando Conversor de Monedas...");

        try {
            converter.fetchExchangeRates();
            System.out.println("Tasas de cambio actualizadas correctamente");

            while (true) {
                mostrarMenu();
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        mostrarMonedasDisponibles();
                        break;
                    case 2:
                        realizarConversion();
                        break;
                    case 3:
                        mostrarHistorial();
                        break;
                    case 4:
                        System.out.println("¡Gracias por usar el conversor!");
                        return;
                    default:
                        System.out.println("Opción no válida. Por favor intente de nuevo.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error al obtener las tasas de cambio: " + e.getMessage());
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n=== Conversor de Monedas ===");
        System.out.println("1. Ver monedas disponibles");
        System.out.println("2. Realizar conversión");
        System.out.println("3. Ver historial de conversiones");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void mostrarMonedasDisponibles() {
        System.out.println("\nMonedas disponibles:");
        for (String currency : CurrencyFilter.getCommonCurrencies()) {
            System.out.println("- " + currency);
        }
    }

    private static void realizarConversion() {
        System.out.print("\nIngrese la moneda de origen (ej: USD): ");
        String monedaOrigen = scanner.nextLine().toUpperCase();

        System.out.print("Ingrese la moneda de destino (ej: EUR): ");
        String monedaDestino = scanner.nextLine().toUpperCase();

        if (!CurrencyFilter.isCommonCurrency(monedaOrigen) ||
                !CurrencyFilter.isCommonCurrency(monedaDestino)) {
            System.out.println("Error: Por favor use solo las monedas disponibles.");
            return;
        }

        System.out.print("Ingrese el monto a convertir: ");
        try {
            double monto = scanner.nextDouble();
            double resultado = converter.convert(monedaOrigen, monedaDestino, monto);
            System.out.printf("%.2f %s = %.2f %s%n",
                    monto, monedaOrigen, resultado, monedaDestino);
        } catch (Exception e) {
            System.out.println("Error: Por favor ingrese un monto válido.");
        }
    }

    private static void mostrarHistorial() {
        System.out.println("\nÚltimas 5 conversiones:");
        List<ConversionRecord> ultimas = converter.getLastConversions(5);
        if (ultimas.isEmpty()) {
            System.out.println("No hay conversiones registradas.");
        } else {
            ultimas.forEach(System.out::println);
        }
    }
}