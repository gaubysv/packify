package com.packify.inventory.repository.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Range {

    private BigDecimal min;
    private BigDecimal max;

    public void setMin(Number min) {
        if (min != null) {
            this.min = new BigDecimal(String.valueOf(min));
        }
    }

    public void setMax(Number max) {
        if (max != null) {
            this.max = new BigDecimal(String.valueOf(max));
        }
    }
}
