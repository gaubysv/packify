package com.packify.inventory.repository.query;

import com.packify.inventory.domain.Category;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ItemsQuery {

    private Long limit;
    private Category category;
    private List<AttributeQuery> attributes = new ArrayList<>();

    public ItemsQuery limit(Integer limit) {
        return limit(limit.longValue());
    }

    public ItemsQuery limit(Long limit) {
        this.limit = limit;
        return this;
    }

    public ItemsQuery withCategory(Category category) {
        this.category = category;
        return this;
    }

    public AttributeQuery withAttribute(String key) {
        AttributeQuery attributeQuery = AttributeQuery.builder().key(key).parent(this).build();
        attributes.add(attributeQuery);
        return attributeQuery;
    }
}
