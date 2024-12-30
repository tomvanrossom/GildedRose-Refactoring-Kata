package com.gildedrose.core.usecase.aging;

class BackstagePassAging implements AgingFunction {
    public BackstagePassAging() {
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
            newQuality = 0;
        }
        return newQuality > 50 ? 50 : newQuality;
    }
}
