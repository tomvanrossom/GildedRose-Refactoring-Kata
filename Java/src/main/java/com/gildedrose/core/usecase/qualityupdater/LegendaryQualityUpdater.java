package com.gildedrose.core.usecase.qualityupdater;

import com.gildedrose.Item;
import com.gildedrose.core.usecase.selectable.Selectable;

import static com.gildedrose.core.domain.SpecialNames.SULFURAS;

class LegendaryQualityUpdater implements SelectableQualityUpdater {
    private final Selectable selectable;

    LegendaryQualityUpdater(Selectable selectable) {
        this.selectable = selectable;
    }


    @Override
    public void updateQuality(Item item) {

        item.quality = 80;
    }

    @Override
    public boolean matches(Item item) {
        return selectable.matches(item);
    }
}
