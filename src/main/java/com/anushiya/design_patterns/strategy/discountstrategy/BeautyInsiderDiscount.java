package com.anushiya.design_patterns.strategy.discountstrategy;

import org.springframework.stereotype.Component;

@Component("beauty_insider")
public class BeautyInsiderDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.90;
    }
}
