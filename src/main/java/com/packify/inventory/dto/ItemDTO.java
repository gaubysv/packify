package com.packify.inventory.dto;

import com.packify.inventory.domain.Category;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ItemDTO {

    private String name;
    private Category category;

    @Builder.Default
    private List<AttributeDTO> attributes = new ArrayList<>();
}
