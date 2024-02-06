package com.packify.trip.service;

import com.packify.api.dto.TripParamsDTO;
import com.packify.trip.dto.TripContextDTO;
import com.packify.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TripContextFactory {

    private final WeatherService weatherService;

    public TripContextDTO create(TripParamsDTO params) {
        return TripContextDTO.builder()
                .days(params.getDays())
                .start(params.getStart())
                .profile(params.getProfile())
                .terrain(params.getTerrain())
                .weather(weatherService.getForecast(params.getStart(), params.getDays(), params.getLocation()))
                .build();
    }
}
