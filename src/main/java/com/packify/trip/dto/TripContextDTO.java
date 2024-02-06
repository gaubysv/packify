package com.packify.trip.dto;

import com.packify.weather.dto.ForecastDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TripContextDTO {

    private Integer days;
    private LocalDate start;
    private ProfileDTO profile;
    private ForecastDTO weather;
    private Terrain terrain;

    public boolean isMultiDay() {
        return days > 1;
    }

    public ProfileDTO getProfile() {
        return profile == null ? ProfileDTO.empty() : profile;
    }
}
