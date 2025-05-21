package com.anushiya.design_patterns.singleton.controller;

import com.anushiya.design_patterns.singleton.service.CurrencyConverterSingleton;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/singleton")
public class CurrencyController {

    @GetMapping("/convert-currency")
    public ResponseEntity<?> convertCurrency(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double amount) {

        try {
            CurrencyConverterSingleton converter = CurrencyConverterSingleton.getInstance();
            double result = converter.convert(from, to, amount);

            return ResponseEntity.ok(Map.of(
                    "from", from.toUpperCase(),
                    "to", to.toUpperCase(),
                    "originalAmount", amount,
                    "convertedAmount", result,
                    "instance", converter.getInstanceId()
            ));

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "error", e.getMessage()
            ));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of(
                    "error", "Unexpected error occurred"
            ));
        }
    }
}
