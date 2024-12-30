package com.gildedrose;

import com.gildedrose.core.usecase.OldQualityUpdater;
import com.gildedrose.core.usecase.QualityUpdater;
import com.gildedrose.core.usecase.QualityUpdaterFactory;

class GildedRose {
    Item[] items;

    QualityUpdater updater = QualityUpdaterFactory.create();

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
