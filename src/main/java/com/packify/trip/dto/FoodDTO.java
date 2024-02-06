package com.packify.trip.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FoodDTO {

    private Integer caloriesPerDay;
    private Integer totalCalories;

    // TODO - add food information based on estimated calories.

    public static FoodDTO empty() {
        return FoodDTO.builder().build();
    }
}
