package com.gildedrose.core.usecase;

import com.gildedrose.Item;

public class QualityUpdaterSelector implements QualityUpdater {

    private QualityUpdater old = new OldQualityUpdater();
    @Override
    public void updateQuality(Item item) {
        old.updateQuality(item);
    }
}
