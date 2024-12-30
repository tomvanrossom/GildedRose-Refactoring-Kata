package com.gildedrose;

import com.gildedrose.core.domain.SpecialNames.*;

import static com.gildedrose.core.domain.SpecialNames.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            updateQuality(item);
        }
    }

    private void updateQuality(Item item) {
        if (!AGED_BRIE.equals(item.name)
                && !BACKSTAGE_PASSES.equals(item.name)) {
            if (item.quality > 0) {
                if (!SULFURAS.equals(item.name)) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
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
        }

        if (!SULFURAS.equals(item.name)) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!AGED_BRIE.equals(item.name)) {
                if (!BACKSTAGE_PASSES.equals(item.name)) {
                    if (item.quality > 0) {
                        if (!SULFURAS.equals(item.name)) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }
}
