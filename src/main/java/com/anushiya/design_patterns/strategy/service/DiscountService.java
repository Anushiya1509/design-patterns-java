package com.anushiya.design_patterns.strategy.service;

import com.anushiya.design_patterns.strategy.model.UserType;
import com.anushiya.design_patterns.strategy.discountstrategy.DiscountStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    @Autowired
    private DiscountStrategyFactory factory;

    public double calculateDiscount(UserType userType, double amount) {
        DiscountStrategy strategy = factory.getStrategy(userType);
        return strategy.applyDiscount(amount);
    }
}
