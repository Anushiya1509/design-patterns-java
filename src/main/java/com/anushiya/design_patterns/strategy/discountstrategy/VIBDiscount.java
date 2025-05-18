package com.anushiya.design_patterns.strategy.discountstrategy;

import org.springframework.stereotype.Component;

@Component("vib")
public class VIBDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.85;
    }
}
