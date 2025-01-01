package com.gildedrose.core.usecase.qualityupdater;

import com.gildedrose.Item;
import com.gildedrose.core.usecase.aging.AgingFunction;
import com.gildedrose.core.usecase.selectable.Selectable;

class LegendaryQualityUpdater implements SelectableQualityUpdater {
    private final AgingFunction agingFunction;
    private final Selectable selectable;

    LegendaryQualityUpdater(AgingFunction agingFunction, Selectable selectable) {
        this.agingFunction = agingFunction;
        this.selectable = selectable;
    }


    @Override
    public void updateQuality(Item item) {

        item.quality = agingFunction.nextQuality(item.sellIn, item.quality);
    }

    @Override
    public boolean matches(Item item) {
        return selectable.matches(item);
    }
}
