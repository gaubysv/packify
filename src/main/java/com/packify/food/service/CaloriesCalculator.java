package com.packify.food.service;

import com.packify.food.domain.ActivityFactor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CaloriesCalculator {

    private final BMRCalculator bmrCalculator;
    private final TDEECalculator tdeeCalculator;

    public Integer calculateForMen(BigDecimal weight, BigDecimal height, Integer age, ActivityFactor activityFactor) {
        BigDecimal bmr = bmrCalculator.calculateForMen(weight, height, age);
        BigDecimal calories = tdeeCalculator.calculate(bmr, activityFactor);
        return calories.intValue();
    }

    public Integer calculateForWomen(BigDecimal weight, BigDecimal height, Integer age, ActivityFactor activityFactor) {
        BigDecimal bmr = bmrCalculator.calculateForWomen(weight, height, age);
        BigDecimal calories = tdeeCalculator.calculate(bmr, activityFactor);
        return calories.intValue();
    }
}
