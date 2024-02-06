package com.packify.food.service;

import com.packify.food.domain.ActivityFactor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TDEECalculator {

    public BigDecimal calculate(BigDecimal bmr, ActivityFactor activityFactor) {
        return bmr.multiply(activityFactor.getValue());
    }
}
