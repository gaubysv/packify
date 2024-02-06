package com.packify.api;

import com.packify.AbstractIntegrationTest;
import com.packify.trip.dto.ChecklistDTO;
import com.packify.trip.dto.ChecklistItemDTO;
import com.packify.trip.dto.Gender;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// TODO - add more tests.
// TODO - clear test data before each test.
// TODO - setup test data before each test.
class TripChecklistControllerIT extends AbstractIntegrationTest {

    @Test
    void shouldReturnTripChecklist() throws Exception {
        String response = mockMvc.perform(
                        get("/trip/checklist")
                                .queryParam("days", "2")
                                .queryParam("profile.age", "27")
                                .queryParam("profile.weight", "80")
                                .queryParam("profile.height", "185")
                                .queryParam("profile.gender", Gender.MALE.name()))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        ChecklistDTO checklist = objectMapper.readValue(response, ChecklistDTO.class);

        assertThat(checklist.getFood())
                .satisfies(food -> {
                    assertThat(food.getCaloriesPerDay()).isEqualTo(3268);
                    assertThat(food.getTotalCalories()).isEqualTo(6536);
                });

        assertThat(checklist.getItems())
                .hasSize(6)
                .extracting(ChecklistItemDTO::getType)
                .containsExactlyInAnyOrderElementsOf(List.of(
                        "Backpack",
                        "Boots",
                        "Pants",
                        "Shirt",
                        "Socks",
                        "Tent"
                ));
    }
}