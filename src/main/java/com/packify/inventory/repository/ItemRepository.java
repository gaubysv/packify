package com.packify.inventory.repository;

import com.packify.inventory.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long>, CustomItemRepository {
}
