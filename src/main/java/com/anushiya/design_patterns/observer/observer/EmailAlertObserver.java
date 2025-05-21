package com.anushiya.design_patterns.observer.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EmailAlertObserver implements BalanceObserver {
    private static final Logger logger = LoggerFactory.getLogger(EmailAlertObserver.class);

    @Override
    public void notifyLowBalance(String accountHolder, double currentBalance) {
        logger.info("[EMAIL] Alert: {} has low balance: ${}", accountHolder, currentBalance);
    }
}
