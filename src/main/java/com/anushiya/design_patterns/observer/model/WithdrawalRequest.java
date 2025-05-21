package com.anushiya.design_patterns.observer.model;

public class WithdrawalRequest {
    private String accountHolder;
    private double initialBalance;
    private double withdrawAmount;
    private double threshold;

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public double getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(double withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }
}
