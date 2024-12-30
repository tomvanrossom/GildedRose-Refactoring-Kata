package com.gildedrose.core.usecase.selectable;

import com.gildedrose.Item;

public interface Selectable {
    public boolean matches(Item item);
}
