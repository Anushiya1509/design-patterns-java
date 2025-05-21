package com.anushiya.design_patterns.observer.controller;

import com.anushiya.design_patterns.observer.model.BankAccount;
import com.anushiya.design_patterns.observer.model.WithdrawalRequest;
import com.anushiya.design_patterns.observer.observer.EmailAlertObserver;
import com.anushiya.design_patterns.observer.observer.LoggerObserver;
import com.anushiya.design_patterns.observer.observer.SMSAlertObserver;
import com.anushiya.design_patterns.observer.service.BankAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/observer")
public class BankController {

    private static final Logger logger = LoggerFactory.getLogger(BankController.class);

    private final BankAccountService service;
    private final EmailAlertObserver emailObserver;
    private final SMSAlertObserver smsObserver;
    private final LoggerObserver loggerObserver;

    public BankController(BankAccountService service, EmailAlertObserver emailObserver,
                          SMSAlertObserver smsObserver, LoggerObserver loggerObserver) {
        this.service = service;
        this.emailObserver = emailObserver;
        this.smsObserver = smsObserver;
        this.loggerObserver = loggerObserver;
    }

    @PostMapping("/withdraw")
    public ResponseEntity<?> withdraw(@RequestBody WithdrawalRequest request) {
        try {
            BankAccount account = service.handleWithdrawal(
                    request.getAccountHolder(),
                    request.getInitialBalance(),
                    request.getWithdrawAmount(),
                    request.getThreshold()
            );
            return ResponseEntity.ok(Map.of(
                    "accountHolder", account.getAccountHolder(),
                    "finalBalance", account.getBalance()
            ));
        } catch (Exception e) {
            logger.error("Error during withdrawal", e);
            return ResponseEntity.internalServerError().body(Map.of(
                    "error", "Unexpected error occurred"
            ));
        }
    }

    @PostMapping("/subscribe")
    public ResponseEntity<?> subscribe(@RequestParam String type) {
        try {
            switch (type.toLowerCase()) {
                case "email" -> service.subscribe(type, emailObserver);
                case "sms" -> service.subscribe(type, smsObserver);
                case "log" -> service.subscribe(type, loggerObserver);
                default -> {
                    return ResponseEntity.badRequest().body(Map.of("error", "Unknown observer type"));
                }
            }
            return ResponseEntity.ok(Map.of("message", type + " observer subscribed"));
        } catch (Exception e) {
            logger.error("Subscription failed", e);
            return ResponseEntity.internalServerError().body(Map.of("error", "Subscription error"));
        }
    }

    @PostMapping("/unsubscribe")
    public ResponseEntity<?> unsubscribe(@RequestParam String type) {
        try {
            switch (type.toLowerCase()) {
                case "email" -> service.unsubscribe(type, emailObserver);
                case "sms" -> service.unsubscribe(type, smsObserver);
                case "log" -> service.unsubscribe(type, loggerObserver);
                default -> {
                    return ResponseEntity.badRequest().body(Map.of("error", "Unknown observer type"));
                }
            }
            return ResponseEntity.ok(Map.of("message", type + " observer unsubscribed"));
        } catch (Exception e) {
            logger.error("Unsubscription failed", e);
            return ResponseEntity.internalServerError().body(Map.of("error", "Unsubscription error"));
        }
    }
}
