package com.packify.weather.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ForecastDTO {

    private TemperatureDTO temperature;
    private List<Conditions> conditions;

    public boolean isSunny() {
        return conditions.contains(Conditions.SUNNY);
    }
}
