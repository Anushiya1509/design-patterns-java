package com.anushiya.design_patterns.observer.subject;

import com.anushiya.design_patterns.observer.model.BankAccount;
import com.anushiya.design_patterns.observer.observer.BalanceObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BankAccountSubject {

    private static final Logger logger = LoggerFactory.getLogger(BankAccountSubject.class);
    private final List<BalanceObserver> observers = new ArrayList<>();

    public void subscribe(BalanceObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            logger.info("Observer subscribed: {}", observer.getClass().getSimpleName());
        }
    }

    public void unsubscribe(BalanceObserver observer) {
        if (observers.remove(observer)) {
            logger.info("Observer unsubscribed: {}", observer.getClass().getSimpleName());
        }
    }

    public void processWithdrawal(BankAccount account, double amount, double threshold) {
        account.withdraw(amount);
        logger.info("Processed withdrawal of ${} for {}. Remaining balance: ${}", amount, account.getAccountHolder(), account.getBalance());

        if (account.getBalance() < threshold) {
            logger.info("Balance below threshold. Notifying observers...");
            for (BalanceObserver observer : observers) {
                observer.notifyLowBalance(account.getAccountHolder(), account.getBalance());
            }
        }
    }
}
