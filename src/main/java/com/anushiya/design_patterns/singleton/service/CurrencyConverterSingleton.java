package com.anushiya.design_patterns.singleton.service;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverterSingleton {

    // 🔒 static reference to the only instance
    private static CurrencyConverterSingleton instance;

    private final Map<String, Double> exchangeRates;

    // 🔐 private constructor
    private CurrencyConverterSingleton() {
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD-CAD", 1.35);
        exchangeRates.put("CAD-USD", 0.74);
        exchangeRates.put("USD-EUR", 0.92);
        exchangeRates.put("EUR-USD", 1.09);
    }

    // ✅ static method to get the instance (lazy initialization)
    public static CurrencyConverterSingleton getInstance() {
        if (instance == null) {
            instance = new CurrencyConverterSingleton();
        }
        return instance;
    }

    public double convert(String from, String to, double amount) {
        String key = from.toUpperCase() + "-" + to.toUpperCase();
        if (!exchangeRates.containsKey(key)) {
            throw new IllegalArgumentException("Unsupported currency conversion: " + key);
        }
        return amount * exchangeRates.get(key);
    }

    public String getInstanceId() {
        return this.toString(); // returns memory ref to prove singleton
    }
}
