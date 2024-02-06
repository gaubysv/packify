package com.packify.trip.service.selector;

import com.packify.trip.dto.ChecklistItemDTO;
import com.packify.trip.dto.TripContextDTO;
import com.packify.weather.dto.ForecastDTO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SunglassesSelector implements ChecklistItemSelector {

    @Override
    public boolean isItemRequired(TripContextDTO context) {
        return Optional.ofNullable(context.getWeather())
                .map(ForecastDTO::isSunny)
                .orElse(Boolean.FALSE);
    }

    @Override
    public ChecklistItemDTO select(TripContextDTO context) {
        // TODO - lookup options in the inventory.
        return ChecklistItemDTO.builder()
                .type("Sunglasses")
                .quantity(1)
                .build();
    }
}
