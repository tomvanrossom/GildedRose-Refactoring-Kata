package com.gildedrose.core.usecase;

import com.gildedrose.Item;
import com.gildedrose.core.domain.SpecialNames;

public class LegendaryQualityUpdater implements SelectableQualityUpdater{
    @Override
    public void updateQuality(Item item) {

        item.quality = 80;
    }

    @Override
    public boolean matches(Item item) {
        return SpecialNames.SULFURAS.equals(item.name);
    }
}
