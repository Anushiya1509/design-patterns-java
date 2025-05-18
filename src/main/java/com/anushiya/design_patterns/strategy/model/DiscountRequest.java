package com.anushiya.design_patterns.strategy.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

public class DiscountRequest {

    @NotBlank(message = "User type is required")
    private String userType;

    @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
    private double amount;

    // Getters and setters
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
