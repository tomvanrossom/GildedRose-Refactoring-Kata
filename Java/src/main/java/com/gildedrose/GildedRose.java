package com.gildedrose;

import com.gildedrose.core.usecase.qualityupdater.Config;
import com.gildedrose.core.usecase.qualityupdater.QualityUpdater;

class GildedRose {
    Item[] items;

    QualityUpdater updater = Config.qualityUpdater();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            updater.updateQuality(item);
        }
    }

}
