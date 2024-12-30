package com.gildedrose.core.usecase;

import com.gildedrose.Item;

public class StandardQualityUpdater implements QualityUpdater{
    @Override
    public void updateQuality(Item item) {
        item.sellIn--;

        int amount = 1;
        if(item.sellIn <= 0){
            amount = amount * 2;
        }
        item.quality = item.quality - amount;

        if(item.quality>50){
            item.quality = 50;
        }
    }
}
