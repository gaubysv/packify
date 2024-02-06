package com.packify.trip.dto;

import com.packify.inventory.dto.ItemDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ChecklistItemDTO {

    private String type;
    private Integer quantity;
    private List<ItemDTO> options;
}
