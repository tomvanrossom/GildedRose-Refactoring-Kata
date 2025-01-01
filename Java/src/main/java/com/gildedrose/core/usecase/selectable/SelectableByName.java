package com.gildedrose.core.usecase.selectable;

import com.gildedrose.Item;
import com.gildedrose.core.domain.SpecialNames;

class SelectableByName implements Selectable<Item> {
    private final SpecialNames name;

    public SelectableByName(SpecialNames name) {
        this.name = name;
    }

    @Override
    public boolean matches(Item item) {
        return name.equals(item.name);
    }
}
