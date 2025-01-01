package com.gildedrose.core.usecase.selectable;

import com.gildedrose.Item;

public interface Selectable<T> {
    boolean matches(T item);
}
