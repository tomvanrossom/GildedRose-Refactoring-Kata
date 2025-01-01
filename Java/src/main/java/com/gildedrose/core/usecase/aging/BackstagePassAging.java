package com.gildedrose.core.usecase.aging;

import com.gildedrose.core.domain.Range;

class BackstagePassAging implements AgingFunction {

    private final Range range;
    public BackstagePassAging(Range range) {
        this.range = range;
    }

    @Override
    public int nextQuality(int newSellIn, int oldQuality) {
        int amount;
        if (newSellIn < 5) {
            amount = 3;
        } else if (newSellIn < 10) {
            amount = 2;
        } else {
            amount = 1;
        }
        int newQuality = oldQuality + amount;

        if (newSellIn < 0) {
            newQuality = this.range.getMin();
        }
        newQuality = range.ensureInRange(newQuality);


        return newQuality;
    }
}
