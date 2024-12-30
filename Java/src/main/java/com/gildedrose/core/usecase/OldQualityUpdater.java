package com.gildedrose.core.usecase;

import com.gildedrose.Item;

import static com.gildedrose.core.domain.SpecialNames.BACKSTAGE_PASSES;

public class OldQualityUpdater implements SelectableQualityUpdater {
    @Override
    public void updateQuality(Item item) {
        if (BACKSTAGE_PASSES.equals(item.name)) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (BACKSTAGE_PASSES.equals(item.name)) {
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
            }
        } else {
            if (item.quality > 0) {
               item.quality = item.quality - 1;
            }
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {

                if (BACKSTAGE_PASSES.equals(item.name)) {
                    item.quality = 0;
                } else {
                    if (item.quality > 0) {
                        item.quality = item.quality - 1;
                    }
                }

        }
    }

    @Override
    public boolean matches(Item item) {
        return BACKSTAGE_PASSES.equals(item.name);
    }
}
