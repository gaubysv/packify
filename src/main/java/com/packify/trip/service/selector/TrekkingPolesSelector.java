package com.packify.trip.service.selector;

import com.packify.trip.dto.ChecklistItemDTO;
import com.packify.trip.dto.Terrain;
import com.packify.trip.dto.TripContextDTO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TrekkingPolesSelector implements ChecklistItemSelector {

    @Override
    public boolean isItemRequired(TripContextDTO context) {
        return Optional.ofNullable(context.getTerrain())
                .map(terrain -> terrain == Terrain.MOUNTAIN)
                .orElse(Boolean.FALSE);
    }

    @Override
    public ChecklistItemDTO select(TripContextDTO context) {
        // TODO - lookup options in the inventory.
        return ChecklistItemDTO.builder()
                .type("Trekking poles")
                .quantity(1)
                .build();
    }
}
