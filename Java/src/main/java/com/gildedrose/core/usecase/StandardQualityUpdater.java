package com.gildedrose.core.usecase;

import com.gildedrose.Item;

public class StandardQualityUpdater implements QualityUpdater {

    private final int rate;
    private final int maxQuality;

    public StandardQualityUpdater(int rate, int maxQuality) {
        this.rate = rate;
        this.maxQuality = maxQuality;
    }

    @Override
    public void updateQuality(Item item) {
        item.sellIn--;

        int amount = rate;
        if (item.sellIn <= 0) {
            amount = amount * 2;
        }
        item.quality = item.quality - amount;

        if (item.quality > this.maxQuality) {
            item.quality = this.maxQuality;
        }
    }
}
