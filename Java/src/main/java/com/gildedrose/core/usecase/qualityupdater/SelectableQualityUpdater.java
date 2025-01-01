package com.gildedrose.core.usecase.qualityupdater;

import com.gildedrose.Item;
import com.gildedrose.core.usecase.selectable.Selectable;

interface SelectableQualityUpdater extends QualityUpdater, Selectable<Item> {
}
