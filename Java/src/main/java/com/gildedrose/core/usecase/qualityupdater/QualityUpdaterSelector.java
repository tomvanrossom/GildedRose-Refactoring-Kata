package com.gildedrose.core.usecase.qualityupdater;

import com.gildedrose.core.domain.Article;

import java.util.List;

class QualityUpdaterSelector implements QualityUpdater {

    private final QualityUpdater standard;
    private final List<SelectableQualityUpdater> selectables;

    QualityUpdaterSelector(QualityUpdater standardQualityUpdater,  List<SelectableQualityUpdater> selectables) {
        this.standard = standardQualityUpdater;
        this.selectables = selectables;
    }

    @Override
    public void updateQuality(Article article) {
        select(article).updateQuality(article);
    }

    private QualityUpdater select(Article article){
        return selectables
            .stream()
            .filter(selectable -> selectable.matches(article))
            .findFirst()
            .map(QualityUpdater.class::cast)
            .orElse(standard);
    }
}
