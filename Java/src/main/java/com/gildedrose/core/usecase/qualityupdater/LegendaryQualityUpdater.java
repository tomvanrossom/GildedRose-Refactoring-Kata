package com.gildedrose.core.usecase.qualityupdater;

import com.gildedrose.Item;
import com.gildedrose.core.usecase.aging.AgingFunction;
import com.gildedrose.core.usecase.selectable.Selectable;
import com.gildedrose.core.usecase.sellin.SellInFunction;

class LegendaryQualityUpdater implements SelectableQualityUpdater {
    private final AgingFunction agingFunction;
    private final SellInFunction sellInFunction;
    private final Selectable selectable;

    LegendaryQualityUpdater(AgingFunction agingFunction, SellInFunction sellInFunction, Selectable selectable) {
        this.agingFunction = agingFunction;
        this.sellInFunction = sellInFunction;
        this.selectable = selectable;
    }


    @Override
    public void updateQuality(Item item) {
        item.sellIn = sellInFunction.nextSellIn(item.sellIn);
        item.quality = agingFunction.nextQuality(item.sellIn, item.quality);
    }

    @Override
    public boolean matches(Item item) {
        return selectable.matches(item);
    }
}
