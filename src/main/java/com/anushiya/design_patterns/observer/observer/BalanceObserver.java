package com.anushiya.design_patterns.observer.observer;

public interface BalanceObserver {
    void notifyLowBalance(String accountHolder, double currentBalance);
}
