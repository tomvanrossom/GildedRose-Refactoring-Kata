package com.gildedrose.core.usecase.aging;

class RateAging implements AgingFunction{

    private final int rate;

    private final int minQuality;
    private final int maxQuality;

    public RateAging(int rate, int maxQuality) {
        this(rate, 0, maxQuality);
    }

    public RateAging(int rate, int minQuality, int maxQuality) {
        this.rate = rate;
        this.minQuality = minQuality;
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
        if(newQuality < this.minQuality){
            newQuality = this.minQuality;
        }
        return newQuality;
    }
}
