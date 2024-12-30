package com.gildedrose.core.usecase.aging;

public interface AgingFunction {
    public int nextQuality(int newSellIn, int oldQuality);
}
