package com.anushiya.design_patterns.observer.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggerObserver implements BalanceObserver {
    private static final Logger logger = LoggerFactory.getLogger(LoggerObserver.class);

    @Override
    public void notifyLowBalance(String accountHolder, double currentBalance) {
        logger.warn("[LOG] Balance warning for {}: ${}", accountHolder, currentBalance);
    }
}
