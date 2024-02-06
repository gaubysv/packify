package com.packify.trip.service;

import com.packify.api.dto.TripParamsDTO;
import com.packify.food.domain.ActivityFactor;
import com.packify.food.service.CaloriesCalculator;
import com.packify.trip.dto.ChecklistDTO;
import com.packify.trip.dto.ChecklistItemDTO;
import com.packify.trip.dto.FoodDTO;
import com.packify.trip.dto.ProfileDTO;
import com.packify.trip.dto.TripContextDTO;
import com.packify.trip.service.selector.ChecklistItemSelector;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TripChecklistService {

    private final TripContextFactory tripContextFactory;
    private final CaloriesCalculator caloriesCalculator;
    private final List<ChecklistItemSelector> checklistItemSelectors;

    public ChecklistDTO getChecklist(TripParamsDTO params) {
        TripContextDTO context = tripContextFactory.create(params);

        return ChecklistDTO.builder()
                .food(getFood(context))
                .items(getItems(context))
                .build();
    }

    private List<ChecklistItemDTO> getItems(TripContextDTO context) {
        return checklistItemSelectors.stream()
                .filter(selector -> selector.isItemRequired(context))
                .map(selector -> selector.select(context))
                .toList();
    }

    private FoodDTO getFood(TripContextDTO context) {
        if (context.getProfile().anyNullFields()) {
            log.info("Unable to estimate food requirements, required parameters are missing {}.", context.getProfile());
            return FoodDTO.empty();
        }

        Integer caloriesPerDay = calculateCaloriesPerDay(context.getProfile());
        Integer totalCalories = caloriesPerDay * context.getDays();

        // TODO - add food items.
        return FoodDTO.builder()
                .caloriesPerDay(caloriesPerDay)
                .totalCalories(totalCalories)
                .build();
    }

    private Integer calculateCaloriesPerDay(ProfileDTO profile) {
        return switch (profile.getGender()) {
            case MALE -> caloriesCalculator.calculateForMen(profile.getWeight(), profile.getHeight(), profile.getAge(), ActivityFactor.VERY);
            case FEMALE -> caloriesCalculator.calculateForWomen(profile.getWeight(), profile.getHeight(), profile.getAge(), ActivityFactor.VERY);
        };
    }
}
