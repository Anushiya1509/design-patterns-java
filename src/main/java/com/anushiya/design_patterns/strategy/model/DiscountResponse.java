package com.anushiya.design_patterns.strategy.model;

public class DiscountResponse {
    private String userType;
    private double originalAmount;
    private double discountedAmount;

    public DiscountResponse(String userType, double originalAmount, double discountedAmount) {
        this.userType = userType;
        this.originalAmount = originalAmount;
        this.discountedAmount = discountedAmount;
    }

    public String getUserType() {
        return userType;
    }

    public double getOriginalAmount() {
        return originalAmount;
    }

    public double getDiscountedAmount() {
        return discountedAmount;
    }
}
