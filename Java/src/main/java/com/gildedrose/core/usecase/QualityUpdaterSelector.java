package com.gildedrose.core.usecase;

import com.gildedrose.Item;
import com.gildedrose.core.domain.SpecialNames;

public class QualityUpdaterSelector implements QualityUpdater {

    private final QualityUpdater old;
    private final QualityUpdater standard;
    private final QualityUpdater legendary;

    public QualityUpdaterSelector(OldQualityUpdater oldQualityUpdater, StandardQualityUpdater standardQualityUpdater, LegendaryQualityUpdater legendaryQualityUpdater) {
        this.old = oldQualityUpdater;
        this.standard = standardQualityUpdater;
        this.legendary = legendaryQualityUpdater;
    }

    @Override
    public void updateQuality(Item item) {
        select(item).updateQuality(item);
    }

    private QualityUpdater select(Item item){
        if(SpecialNames.SULFURAS.equals(item.name)){
            return this.legendary;
        }
        for(SpecialNames name: SpecialNames.values()){
            if(name.equals(item.name)){
                return old;
            }
        }
        return standard;
    }
}
