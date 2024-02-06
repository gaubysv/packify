package com.packify.api;

import com.packify.api.dto.TripParamsDTO;
import com.packify.trip.dto.ChecklistDTO;
import com.packify.trip.service.TripChecklistService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

// TODO - add swagger.
// TODO - add global exception handler.
// TODO - implement parameter validation.
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/trip/checklist")
public class TripChecklistController {

    private final TripChecklistService tripChecklistService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ChecklistDTO getChecklist(@Valid TripParamsDTO params) {
        return tripChecklistService.getChecklist(params);
    }
}
