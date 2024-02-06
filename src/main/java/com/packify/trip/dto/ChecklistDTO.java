package com.packify.trip.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ChecklistDTO {

    // TODO - add water estimate.
    private FoodDTO food;

    // TODO - maybe categorize items.
    private List<ChecklistItemDTO> items;
}
