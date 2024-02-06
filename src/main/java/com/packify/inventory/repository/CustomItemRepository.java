package com.packify.inventory.repository;

import com.packify.inventory.repository.query.ItemsQuery;

import java.util.List;

public interface CustomItemRepository {

    List<Long> lookup(ItemsQuery query);
}
