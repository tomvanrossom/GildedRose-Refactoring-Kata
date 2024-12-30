package com.gildedrose.core.usecase;

import com.gildedrose.Item;

public interface Selectable {
    public boolean matches(Item item);
}
