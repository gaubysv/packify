package com.packify.weather.service;

import com.packify.weather.dto.Conditions;
import com.packify.weather.dto.ForecastDTO;
import com.packify.weather.dto.TemperatureDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static com.packify.weather.dto.Conditions.CLOUDY;
import static com.packify.weather.dto.Conditions.RAINY;
import static com.packify.weather.dto.Conditions.SNOWY;
import static com.packify.weather.dto.Conditions.STORMY;
import static com.packify.weather.dto.Conditions.SUNNY;
import static com.packify.weather.dto.Conditions.WINDY;

@Service
public class DummyWeatherService implements WeatherService {

    @Override
    public ForecastDTO getForecast(LocalDate date, Integer days, String location) {
        // TODO - retrieve weather forecast from some 3rd party service.
        return ForecastDTO.builder()
                .temperature(getTemperature(date.getMonth()))
                .conditions(getConditions(date.getMonth()))
                .build();
    }

    private TemperatureDTO getTemperature(Month month) {
        return switch (month) {
            case MARCH -> TemperatureDTO.builder().day(5).night(-2).build();
            case APRIL -> TemperatureDTO.builder().day(12).night(2).build();
            case MAY -> TemperatureDTO.builder().day(18).night(7).build();
            case JUNE -> TemperatureDTO.builder().day(21).night(11).build();
            case JULY -> TemperatureDTO.builder().day(23).night(14).build();
            case AUGUST -> TemperatureDTO.builder().day(23).night(-13).build();
            case SEPTEMBER -> TemperatureDTO.builder().day(18).night(9).build();
            case OCTOBER -> TemperatureDTO.builder().day(11).night(4).build();
            case NOVEMBER -> TemperatureDTO.builder().day(5).night(1).build();
            case DECEMBER -> TemperatureDTO.builder().day(1).night(-2).build();
            case JANUARY -> TemperatureDTO.builder().day(-1).night(-5).build();
            case FEBRUARY -> TemperatureDTO.builder().day(0).night(-4).build();
        };
    }

    private List<Conditions> getConditions(Month month) {
        return switch (month) {
            case MARCH, APRIL, MAY -> List.of(CLOUDY, WINDY);
            case JUNE, JULY, AUGUST -> List.of(SUNNY);
            case SEPTEMBER, OCTOBER, NOVEMBER -> List.of(STORMY, RAINY);
            case DECEMBER, JANUARY, FEBRUARY -> List.of(SNOWY);
        };
    }
}
