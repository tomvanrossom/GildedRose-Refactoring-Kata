package com.gildedrose.core.usecase.aging;

import com.gildedrose.core.domain.Range;

class RateAging implements AgingFunction{

    private final int rate;

    private final Range range;

    public RateAging(int rate, Range range) {
        this.rate = rate;
        this.range = range;
    }

    @Override
    public int nextQuality(int newSellIn, int oldQuality) {
        int newQuality;

        int amount = rate;
        if (newSellIn <= 0) {
            amount = amount * 2;
        }
        newQuality = oldQuality + amount;

        newQuality = range.ensureInRange(newQuality);

        return newQuality;
    }
}
