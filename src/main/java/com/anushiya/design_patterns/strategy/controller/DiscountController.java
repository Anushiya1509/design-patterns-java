package com.anushiya.design_patterns.strategy.controller;

import com.anushiya.design_patterns.strategy.model.DiscountRequest;
import com.anushiya.design_patterns.strategy.model.DiscountResponse;
import com.anushiya.design_patterns.strategy.model.UserType;
import com.anushiya.design_patterns.strategy.service.DiscountService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/strategy")
public class DiscountController {

    private static final Logger logger = LoggerFactory.getLogger(DiscountController.class);

    @Autowired
    private DiscountService discountService;

    @PostMapping("/discount")
    public ResponseEntity<?> getDiscount(@Valid @RequestBody DiscountRequest request) {
        try {
            UserType userType = UserType.valueOf(request.getUserType().toUpperCase());
            double discountedAmount = discountService.calculateDiscount(userType, request.getAmount());

            return ResponseEntity.ok(new DiscountResponse(
                    userType.name(),
                    request.getAmount(),
                    discountedAmount
            ));

        } catch (IllegalArgumentException e) {
            logger.error("Invalid userType input: {}", request.getUserType(), e);
            return ResponseEntity.badRequest().body(Map.of(
                    "error", "Invalid userType. Expected one of: GUEST, BEAUTY_INSIDER, VIB, ROUGE"
            ));

        } catch (Exception e) {
            logger.error("Unexpected error occurred while calculating discount", e);
            return ResponseEntity.internalServerError().body(Map.of(
                    "error", "Something went wrong. Please try again later!"
            ));
        }
    }
}
