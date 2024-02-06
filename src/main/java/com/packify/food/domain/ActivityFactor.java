package com.packify.food.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public enum ActivityFactor {

    LIGHT(BigDecimal.valueOf(1.375)),
    MODERATE(BigDecimal.valueOf(1.55)),
    VERY(BigDecimal.valueOf(1.725));

    private final BigDecimal value;
}
