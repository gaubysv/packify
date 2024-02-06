package com.packify.trip.service.selector;

import com.packify.trip.dto.ChecklistItemDTO;
import com.packify.trip.dto.TripContextDTO;
import org.springframework.stereotype.Component;

@Component
public class TentSelector implements ChecklistItemSelector {

    @Override
    public boolean isItemRequired(TripContextDTO context) {
        return context.isMultiDay();
    }

    @Override
    public ChecklistItemDTO select(TripContextDTO context) {
        // TODO - lookup options in the inventory.
        return ChecklistItemDTO.builder()
                .type("Tent")
                .quantity(1)
                .build();
    }
}
