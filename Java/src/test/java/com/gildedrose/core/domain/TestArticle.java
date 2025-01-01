package com.gildedrose.core.domain;

public class TestArticle implements Article{

    private final String name;

    private int sellIn;

    private int quality;

    public TestArticle(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSellIn() {
        return sellIn;
    }

    @Override
    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    @Override
    public int getQuality() {
        return quality;
    }

    @Override
    public void setQuality(int quality) {
        this.quality = quality;
    }
}
