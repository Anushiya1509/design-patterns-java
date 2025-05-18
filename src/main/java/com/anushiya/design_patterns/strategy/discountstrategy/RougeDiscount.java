package com.anushiya.design_patterns.strategy.discountstrategy;

import org.springframework.stereotype.Component;

@Component("rouge")
public class RougeDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.80;
    }
}
