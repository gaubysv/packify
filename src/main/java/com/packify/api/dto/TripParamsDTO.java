package com.packify.api.dto;

import com.packify.trip.dto.ProfileDTO;
import com.packify.trip.dto.Terrain;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TripParamsDTO {

    @NotNull(message = "days is mandatory.")
    @Positive(message = "days must be a positive number.")
    private Integer days;
    private LocalDate start;
    private String location;
    private ProfileDTO profile;
    private Terrain terrain;

    public LocalDate getStart() {
        return start == null ? LocalDate.now() : start;
    }
}
