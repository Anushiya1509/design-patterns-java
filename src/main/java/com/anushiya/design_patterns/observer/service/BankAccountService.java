package com.anushiya.design_patterns.observer.service;

import com.anushiya.design_patterns.observer.model.BankAccount;
import com.anushiya.design_patterns.observer.subject.BankAccountSubject;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {

    private final BankAccountSubject subject;

    public BankAccountService(BankAccountSubject subject) {
        this.subject = subject;
    }

    public BankAccount handleWithdrawal(String accountHolder, double initialBalance, double withdrawAmount, double threshold) {
        BankAccount account = new BankAccount(accountHolder, initialBalance);
        subject.processWithdrawal(account, withdrawAmount, threshold);
        return account;
    }

    public void subscribe(String type, Object observer) {
        subject.subscribe((com.anushiya.design_patterns.observer.observer.BalanceObserver) observer);
    }

    public void unsubscribe(String type, Object observer) {
        subject.unsubscribe((com.anushiya.design_patterns.observer.observer.BalanceObserver) observer);
    }
}
