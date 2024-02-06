package com.packify.inventory.repository;

import com.packify.inventory.domain.QAttribute;
import com.packify.inventory.domain.QItem;
import com.packify.inventory.repository.query.AttributeQuery;
import com.packify.inventory.repository.query.ItemsQuery;
import com.packify.inventory.repository.query.Range;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomItemRepositoryImpl implements CustomItemRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Long> lookup(ItemsQuery query) {
        QItem item = QItem.item;
        QAttribute attribute = QAttribute.attribute;

        JPQLQuery<Long> jpqlQuery = jpaQueryFactory.selectFrom(item)
                .select(item.id)
                .innerJoin(item.attributes, attribute)
                .where(buildItemsPredicate(query, item, attribute));

        if (query.getLimit() != null) {
            jpqlQuery.limit(query.getLimit());
        }

        return jpqlQuery.fetch();
    }

    private Predicate buildItemsPredicate(ItemsQuery query, QItem item, QAttribute attribute) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (query.getCategory() != null) {
            predicate.and(item.category.eq(query.getCategory()));
        }

        for (AttributeQuery attributeQuery : query.getAttributes()) {
            predicate.and(buildAttributesPredicate(attributeQuery, attribute));
        }

        return predicate;
    }

    private Predicate buildAttributesPredicate(AttributeQuery attributeQuery, QAttribute attribute) {
        return switch (attributeQuery.getOperator()) {
            case EQUAL -> buildEqualsPredicate(attribute, attributeQuery.getKey(), attributeQuery.getValue());
            case RANGE -> buildRangePredicate(attribute, attributeQuery.getKey(), attributeQuery.getRange());
        };
    }

    private Predicate buildEqualsPredicate(QAttribute attribute, String key, String value) {
        return attribute.key.eq(key).and(attribute.value.eq(value));
    }

    private Predicate buildRangePredicate(QAttribute attribute, String key, Range range) {
        if (range.getMin() != null && range.getMax() != null) {
            return attribute.key.eq(key).and(attribute.value.castToNum(BigDecimal.class).between(range.getMin(), range.getMax()));
        } else if (range.getMin() != null) {
            return attribute.key.eq(key).and(attribute.value.castToNum(BigDecimal.class).goe(range.getMin()));
        } else if (range.getMax() != null) {
            return attribute.key.eq(key).and(attribute.value.castToNum(BigDecimal.class).loe(range.getMax()));
        }

        throw new IllegalArgumentException("Bad range query.");
    }
}
