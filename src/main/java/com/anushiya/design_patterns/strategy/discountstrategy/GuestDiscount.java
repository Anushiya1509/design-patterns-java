package com.anushiya.design_patterns.strategy.discountstrategy;

import org.springframework.stereotype.Component;

@Component("guest")
public class GuestDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount; // No discount
    }
}
