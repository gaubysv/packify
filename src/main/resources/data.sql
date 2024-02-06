insert into items(id, name, category)
values
    (1, 'Osprey 18 Litre Ultralight Stuff Pack - Packable Daypack - Latest Model', 'BAGS'),
    (2, 'Osprey Exos 38 Litre Ultralight Overnight Backpack', 'BAGS'),
    (3, 'Osprey Exos 58 Litre Ultralight Backpack - Latest Model', 'BAGS'),
    (4, 'Gregory Contour 70 Litre Backpack', 'BAGS');

insert into attributes(id, attribute_key, attribute_value, display_value, item_id)
values
    (101, 'CAPACITY', '18', '18 Litres', 1),
    (102, 'BRAND', 'Osprey', 'Osprey', 1),
    (103, 'WEIGHT', '149', '149 grams', 1),
    (104, 'COLOR', 'BLACK', 'Black', 1),
    --
    (201, 'CAPACITY', '38', '38 Litres', 2),
    (202, 'BRAND', 'Osprey', 'Osprey', 2),
    (203, 'WEIGHT', '1113', '1.13 kg.', 2),
    (204, 'COLOR', 'GREEN', 'Green', 2),
    --
    (301, 'CAPACITY', '58', '58 Litres', 3),
    (302, 'BRAND', 'Osprey', 'Osprey', 3),
    (303, 'WEIGHT', '1288', '1.288 kg.', 3),
    (304, 'COLOR', 'GREY', 'Grey', 3),
    --
    (401, 'CAPACITY', '70', '70 Litres', 4),
    (402, 'BRAND', 'Gregory', 'Gregory', 4),
    (403, 'WEIGHT', '1810', '1.81 kg.', 4),
    (404, 'COLOR', 'BLUE', 'Blue', 4);

-- TODO - add more items to the inventory.