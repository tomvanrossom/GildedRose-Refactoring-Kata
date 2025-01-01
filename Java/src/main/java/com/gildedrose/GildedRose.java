package com.gildedrose;

import com.gildedrose.core.usecase.qualityupdater.Config;
import com.gildedrose.core.usecase.qualityupdater.QualityUpdater;

import static com.gildedrose.ItemWrapper.wrap;

class GildedRose {
    Item[] items;

    QualityUpdater updater = Config.qualityUpdater();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            updater.updateQuality(wrap(item));
        }
    }

}
