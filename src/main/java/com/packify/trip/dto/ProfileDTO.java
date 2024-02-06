package com.packify.trip.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.ObjectUtils;

import java.math.BigDecimal;

@Data
@Builder
@ToString
public class ProfileDTO {

    private Integer age;
    private BigDecimal weight;
    private BigDecimal height;
    private Gender gender;

    public static ProfileDTO empty() {
        return ProfileDTO.builder().build();
    }

    public boolean anyNullFields() {
        return ObjectUtils.anyNull(age, weight, height, gender);
    }
}
