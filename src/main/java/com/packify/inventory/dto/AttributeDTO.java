package com.packify.inventory.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AttributeDTO {

    private String key;
    private String value;
    private String displayValue;
}
