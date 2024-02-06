package com.packify.trip.service.selector;

import com.packify.trip.dto.ChecklistItemDTO;
import com.packify.trip.dto.TripContextDTO;

// TODO - implement more selectors.
public interface ChecklistItemSelector {

    /**
     * Checks if item is required based on the given trip context.
     *
     * @param context contains trip related information.
     * @return true if required
     */
    default boolean isItemRequired(TripContextDTO context) {
        return true;
    }

    /**
     * Selects checklist item.
     *
     * @param context contains trip related information.
     * @return checklist item
     */
    ChecklistItemDTO select(TripContextDTO context);
}
