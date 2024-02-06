package com.packify.trip.service.selector;

import com.packify.inventory.domain.Category;
import com.packify.inventory.dto.ItemDTO;
import com.packify.inventory.repository.query.ItemsQuery;
import com.packify.inventory.repository.query.Range;
import com.packify.inventory.service.InventoryService;
import com.packify.trip.dto.ChecklistItemDTO;
import com.packify.trip.dto.TripContextDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BackpackSelector implements ChecklistItemSelector {

    private final InventoryService inventoryService;

    @Override
    public ChecklistItemDTO select(TripContextDTO context) {
        return ChecklistItemDTO.builder()
                .type("Backpack")
                .quantity(1)
                .options(lookupOptions(context))
                .build();
    }

    private List<ItemDTO> lookupOptions(TripContextDTO context) {
        ItemsQuery query = new ItemsQuery()
                .limit(3)
                .withCategory(Category.BAGS)
                .withAttribute("CAPACITY").havingValueInRange(getCapacityRange(context.getDays()));

        return inventoryService.lookup(query);
    }

    private Range getCapacityRange(int days) {
        if (days == 1) {
            return getRange(null, 30);
        }

        if (2 <= days && days <= 3) {
            return getRange(30, 50);
        }

        if (4 <= days && days <= 7) {
            return getRange(50, 70);
        }

        return getRange(70, null);
    }

    private Range getRange(Number min, Number max) {
        Range range = new Range();
        range.setMin(min);
        range.setMax(max);
        return range;
    }
}
