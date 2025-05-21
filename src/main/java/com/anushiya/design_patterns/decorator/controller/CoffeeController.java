package com.anushiya.design_patterns.decorator.controller;

import com.anushiya.design_patterns.decorator.model.Coffee;
import com.anushiya.design_patterns.decorator.service.CoffeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/decorator")
public class CoffeeController {

    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @PostMapping("/coffee")
    public ResponseEntity<?> createCoffee(@RequestBody Map<String, List<String>> request) {
        try {
            List<String> toppings = request.getOrDefault("toppings", List.of());
            Coffee coffee = coffeeService.prepareCoffee(toppings);

            return ResponseEntity.ok(Map.of(
                    "description", coffee.getDescription(),
                    "cost", coffee.getCost()
            ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", "Unexpected error occurred"));
        }
    }
}
