package com.gildedrose.core.usecase.selectable;

import com.gildedrose.Item;

public class SelectsAll implements Selectable {
    @Override
    public boolean matches(Item item) {
        return true;
    }
}
