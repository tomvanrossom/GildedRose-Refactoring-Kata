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
            if (!AGED_BRIE.equals(items[i].name)
                    && !BACKSTAGE_PASSES.equals(items[i].name)) {
                if (items[i].quality > 0) {
                    if (!SULFURAS.equals(items[i].name)) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (BACKSTAGE_PASSES.equals(items[i].name)) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!SULFURAS.equals(items[i].name)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!AGED_BRIE.equals(items[i].name)) {
                    if (!BACKSTAGE_PASSES.equals(items[i].name)) {
                        if (items[i].quality > 0) {
                            if (!SULFURAS.equals(items[i].name)) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
