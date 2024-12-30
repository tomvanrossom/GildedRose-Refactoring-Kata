package com.gildedrose.core.usecase;

import com.gildedrose.Item;

import java.util.List;

public class QualityUpdaterSelector implements QualityUpdater {

    private final QualityUpdater standard;
    private final List<SelectableQualityUpdater> selectables;

    public QualityUpdaterSelector(QualityUpdater standardQualityUpdater,  List<SelectableQualityUpdater> selectables) {
        this.standard = standardQualityUpdater;
        this.selectables = selectables;
    }

    @Override
    public void updateQuality(Item item) {
        select(item).updateQuality(item);
    }

    private QualityUpdater select(Item item){
        return selectables
            .stream()
            .filter(selectable -> selectable.matches(item))
            .findFirst()
            .map(QualityUpdater.class::cast)
            .orElse(standard);
    }
}
