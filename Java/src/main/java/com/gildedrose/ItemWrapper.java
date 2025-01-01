package com.gildedrose;

import com.gildedrose.core.domain.Article;

public class ItemWrapper implements Article {

    private final Item item;

    ItemWrapper(Item item) {
        this.item = item;
    }

    public static ItemWrapper wrap(Item item){
        return new ItemWrapper(item);
    }

    @Override
    public String getName() {
        return item.name;
    }

    @Override
    public int getSellIn() {
        return item.sellIn;
    }

    @Override
    public void setSellIn(int newValue) {
        item.sellIn = newValue;
    }

    @Override
    public int getQuality() {
        return item.quality;
    }

    @Override
    public void setQuality(int newQuality) {
        item.quality = newQuality;
    }
}
