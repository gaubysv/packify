package com.packify.weather.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TemperatureDTO {

    private Integer day;
    private Integer night;
}
