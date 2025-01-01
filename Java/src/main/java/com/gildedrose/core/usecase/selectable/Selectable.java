package com.gildedrose.core.usecase.selectable;

public interface Selectable<T> {
    boolean matches(T value);
}
