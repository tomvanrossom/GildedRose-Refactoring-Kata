package com.gildedrose.core.usecase.qualityupdater;

import com.gildedrose.core.domain.Article;
import com.gildedrose.core.usecase.aging.AgingFunction;
import com.gildedrose.core.usecase.selectable.Selectable;
import com.gildedrose.core.usecase.sellin.SellInFunction;

class GenericQualityUpdater implements SelectableQualityUpdater {

    private final Selectable selectable;
    private final SellInFunction sellInFunction;
    private final AgingFunction agingFunction;

    GenericQualityUpdater(Selectable selectable, SellInFunction sellInFunction, AgingFunction agingFunction) {
        this.selectable = selectable;
        this.sellInFunction = sellInFunction;
        this.agingFunction = agingFunction;
    }

    @Override
    public void updateQuality(Article article) {
        article.setSellIn(sellInFunction.nextSellIn(article.getSellIn()));
        article.setQuality(agingFunction.nextQuality(article.getSellIn(), article.getQuality()));
    }

    @Override
    public boolean matches(Article article) {
        return selectable.matches(article);
    }
}
