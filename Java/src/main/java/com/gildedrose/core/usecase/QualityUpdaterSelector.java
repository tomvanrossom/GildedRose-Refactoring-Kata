package com.gildedrose.core.usecase;

import com.gildedrose.Item;

public class QualityUpdaterSelector implements QualityUpdater {

    private final QualityUpdater old;

    public QualityUpdaterSelector(OldQualityUpdater oldQualityUpdater) {
        this.old = oldQualityUpdater;
    }

    @Override
    public void updateQuality(Item item) {
        select(item).updateQuality(item);
    }

    private QualityUpdater select(Item item){
        return old;
    }
}
