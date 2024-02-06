package com.packify.inventory.service;

import com.packify.inventory.domain.Item;
import com.packify.inventory.dto.ItemDTO;
import com.packify.inventory.mapper.ItemMapper;
import com.packify.inventory.repository.ItemRepository;
import com.packify.inventory.repository.query.ItemsQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;

    @Transactional
    public List<ItemDTO> lookup(ItemsQuery query) {
        List<Long> ids = itemRepository.lookup(query);
        List<Item> items = itemRepository.findAllById(ids);
        return itemMapper.mapItems(items);
    }
}
