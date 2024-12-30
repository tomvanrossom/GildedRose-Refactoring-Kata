package com.gildedrose.core.usecase;

import com.gildedrose.Item;
import com.gildedrose.core.domain.SpecialNames;

public class QualityUpdaterSelector implements QualityUpdater {

    private final QualityUpdater old;
    private final StandardQualityUpdater standard;

    public QualityUpdaterSelector(OldQualityUpdater oldQualityUpdater, StandardQualityUpdater standardQualityUpdater) {
        this.old = oldQualityUpdater;
        this.standard = standardQualityUpdater;
    }

    @Override
    public void updateQuality(Item item) {
        select(item).updateQuality(item);
    }

    private QualityUpdater select(Item item){
        for(SpecialNames name: SpecialNames.values()){
            if(name.equals(item.name)){
                return old;
            }
        }
        return standard;
    }
}
