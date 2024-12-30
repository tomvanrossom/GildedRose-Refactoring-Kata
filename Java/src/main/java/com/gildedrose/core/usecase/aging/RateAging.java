package com.gildedrose.core.usecase.aging;

public class RateAging implements AgingFunction{

    private final int rate;
    private final int maxQuality;

    public RateAging(int rate, int maxQuality) {
        this.rate = rate;
        this.maxQuality = maxQuality;
    }

    @Override
    public int nextQuality(int newSellIn, int oldQuality) {
        int newQuality;

        int amount = rate;
        if (newSellIn <= 0) {
            amount = amount * 2;
        }
        newQuality = oldQuality + amount;

        if (newQuality > this.maxQuality) {
            newQuality = this.maxQuality;
        }
        return newQuality;
    }
}
