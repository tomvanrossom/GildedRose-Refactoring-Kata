package com.gildedrose;

import com.gildedrose.core.usecase.OldQualityUpdater;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            OldQualityUpdater.updateQuality(item);
        }
    }

}
