package com.gildedrose.core.usecase;

import com.gildedrose.Item;

import static com.gildedrose.core.domain.SpecialNames.BACKSTAGE_PASSES;

public class BackStagePassesQualityUpdater implements SelectableQualityUpdater {
    @Override
    public void updateQuality(Item item) {

        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    @Override
    public boolean matches(Item item) {
        return BACKSTAGE_PASSES.equals(item.name);
    }
}
