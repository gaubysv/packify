package com.packify.food.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RevisedHarrisBenedictFormulaBasedBMRCalculator implements BMRCalculator {

    @Override
    public BigDecimal calculateForMen(BigDecimal weight, BigDecimal height, Integer age) {
        return BigDecimal.valueOf(88.362)
                .add(BigDecimal.valueOf(13.397).multiply(weight))
                .add(BigDecimal.valueOf(4.799).multiply(height))
                .subtract(BigDecimal.valueOf(5.677).multiply(BigDecimal.valueOf(age)));
    }

    @Override
    public BigDecimal calculateForWomen(BigDecimal weight, BigDecimal height, Integer age) {
        return BigDecimal.valueOf(447.593)
                .add(BigDecimal.valueOf(9.247).multiply(weight))
                .add(BigDecimal.valueOf(3.098).multiply(height))
                .subtract(BigDecimal.valueOf(4.33).multiply(BigDecimal.valueOf(age)));
    }
}
