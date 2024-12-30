package com.gildedrose.core.usecase.qualityupdater;

import com.gildedrose.Item;

import static com.gildedrose.core.domain.SpecialNames.SULFURAS;

class LegendaryQualityUpdater implements SelectableQualityUpdater {
    @Override
    public void updateQuality(Item item) {

        item.quality = 80;
    }

    @Override
    public boolean matches(Item item) {
        return SULFURAS.equals(item.name);
    }
}
