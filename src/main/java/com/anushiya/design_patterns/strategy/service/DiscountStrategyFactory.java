package com.anushiya.design_patterns.strategy.service;

import com.anushiya.design_patterns.strategy.model.UserType;
import com.anushiya.design_patterns.strategy.discountstrategy.DiscountStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DiscountStrategyFactory {

    @Autowired
    private ApplicationContext context;

    public DiscountStrategy getStrategy(UserType type) {
        return switch (type) {
            case GUEST -> context.getBean("guest", DiscountStrategy.class);
            case BEAUTY_INSIDER -> context.getBean("beauty_insider", DiscountStrategy.class);
            case VIB -> context.getBean("vib", DiscountStrategy.class);
            case ROUGE -> context.getBean("rouge", DiscountStrategy.class);
        };
    }
}

