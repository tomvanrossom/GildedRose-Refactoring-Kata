package com.gildedrose.core.usecase;

import com.gildedrose.Item;

public class LegendaryQualityUpdater implements QualityUpdater{
    @Override
    public void updateQuality(Item item) {

        item.quality = 80;
    }
}
