package com.gildedrose.core.usecase.aging;

public class BackstagePassAging implements AgingFunction {
    public BackstagePassAging() {
    }

    @Override
    public int nextQuality(int newSellIn, int oldQuality) {
        int rate;
        if (newSellIn < 5) {
            rate = 3;
        } else if (newSellIn < 10) {
            rate = 2;
        } else {
            rate = 1;
        }
        int newQuality = oldQuality + rate;

        if (newSellIn < 0) {
            newQuality = 0;
        }
        return newQuality > 50 ? 50 : newQuality;
    }
}
