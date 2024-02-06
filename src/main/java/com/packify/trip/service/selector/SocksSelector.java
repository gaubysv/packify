package com.packify.trip.service.selector;

import com.packify.trip.dto.ChecklistItemDTO;
import com.packify.trip.dto.TripContextDTO;
import org.springframework.stereotype.Component;

@Component
public class SocksSelector implements ChecklistItemSelector {

    @Override
    public ChecklistItemDTO select(TripContextDTO context) {
        // TODO - lookup options in the inventory.
        return ChecklistItemDTO.builder()
                .type("Socks")
                .quantity(context.getDays())
                .build();
    }
}
