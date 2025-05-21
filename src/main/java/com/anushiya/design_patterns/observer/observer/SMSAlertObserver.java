package com.anushiya.design_patterns.observer.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SMSAlertObserver implements BalanceObserver {
    private static final Logger logger = LoggerFactory.getLogger(SMSAlertObserver.class);

    @Override
    public void notifyLowBalance(String accountHolder, double currentBalance) {
        logger.info("[SMS] Alert: {} has low balance: ${}", accountHolder, currentBalance);
    }
}
