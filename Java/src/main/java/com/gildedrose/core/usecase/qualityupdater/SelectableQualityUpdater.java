package com.gildedrose.core.usecase.qualityupdater;

import com.gildedrose.core.domain.Article;
import com.gildedrose.core.usecase.selectable.Selectable;

interface SelectableQualityUpdater extends QualityUpdater, Selectable<Article> {
}
