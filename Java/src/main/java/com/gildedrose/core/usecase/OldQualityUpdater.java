package com.gildedrose.core.usecase;

import com.gildedrose.Item;

import static com.gildedrose.core.domain.SpecialNames.*;

public class OldQualityUpdater implements QualityUpdater {
    @Override
    public void updateQuality(Item item) {
        if (AGED_BRIE.equals(item.name) || BACKSTAGE_PASSES.equals(item.name)) {
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
            if (AGED_BRIE.equals(item.name)) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            } else {
                if (BACKSTAGE_PASSES.equals(item.name)) {
                    item.quality = 0;
                } else {
                    if (item.quality > 0) {
                        item.quality = item.quality - 1;
                    }
                }
            }
        }
    }
}
