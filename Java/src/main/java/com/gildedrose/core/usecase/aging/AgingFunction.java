package com.gildedrose.core.usecase.aging;

public interface AgingFunction {
    int nextQuality(int newSellIn, int oldQuality);
}
