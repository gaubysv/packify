package com.packify.food.service;

import java.math.BigDecimal;

public interface BMRCalculator {

    BigDecimal calculateForMen(BigDecimal weight, BigDecimal height, Integer age);

    BigDecimal calculateForWomen(BigDecimal weight, BigDecimal height, Integer age);
}
