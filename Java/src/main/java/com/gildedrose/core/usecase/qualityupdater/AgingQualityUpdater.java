package com.gildedrose.core.usecase.qualityupdater;

import com.gildedrose.Item;
import com.gildedrose.core.usecase.aging.AgingFunction;
import com.gildedrose.core.usecase.selectable.Selectable;

class AgingQualityUpdater implements SelectableQualityUpdater {

    private final Selectable selectable;
    private final AgingFunction agingFunction;

    public AgingQualityUpdater(Selectable selectable, AgingFunction agingFunction) {
        this.selectable = selectable;
        this.agingFunction = agingFunction;
    }

    @Override
    public void updateQuality(Item item) {
        item.sellIn--;

        item.quality = agingFunction.nextQuality(item.sellIn, item.quality);
    }

    @Override
    public boolean matches(Item item) {
        return selectable.matches(item);
    }
}