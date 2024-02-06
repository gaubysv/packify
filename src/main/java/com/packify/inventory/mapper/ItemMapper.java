package com.packify.inventory.mapper;

import com.packify.inventory.domain.Item;
import com.packify.inventory.dto.ItemDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    List<ItemDTO> mapItems(List<Item> item);
}
