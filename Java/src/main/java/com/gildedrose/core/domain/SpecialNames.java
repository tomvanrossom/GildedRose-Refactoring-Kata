package com.gildedrose.core.domain;

public enum SpecialNames {
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS("Sulfuras, Hand of Ragnaros");

    public final String fullName;

    SpecialNames(String fullName) {
        this.fullName = fullName;
    }

    public boolean equals(String name){
        return this.fullName.equals(name);
    }
}
