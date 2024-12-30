package com.gildedrose.core.usecase;

import com.gildedrose.Item;
import com.gildedrose.core.domain.SpecialNames;

public class SelectableByName implements Selectable{
    private final SpecialNames name;

    public SelectableByName(SpecialNames name) {
        this.name = name;
    }

    @Override
    public boolean matches(Item item) {
        return name.equals(item.name);
    }
}
