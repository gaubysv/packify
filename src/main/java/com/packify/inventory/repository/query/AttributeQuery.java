package com.packify.inventory.repository.query;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AttributeQuery {

    private String key;
    private Operator operator;
    private ItemsQuery parent;

    private String value;
    private Range range;

    public ItemsQuery havingValueEqualTo(String value) {
        this.value = value;
        this.operator = Operator.EQUAL;
        return parent;
    }

    public ItemsQuery havingValueInRange(Range range) {
        this.range = range;
        this.operator = Operator.RANGE;
        return parent;
    }
}
