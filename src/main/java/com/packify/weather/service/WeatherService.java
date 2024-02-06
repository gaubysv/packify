package com.packify.weather.service;

import com.packify.weather.dto.ForecastDTO;

import java.time.LocalDate;

public interface WeatherService {

    ForecastDTO getForecast(LocalDate date, Integer days, String city);
}
