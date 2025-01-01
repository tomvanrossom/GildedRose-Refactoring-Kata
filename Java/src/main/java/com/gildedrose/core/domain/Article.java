package com.gildedrose.core.domain;

public interface Article {
    String getName();

    int getSellIn();

    void setSellIn(int newValue);

    int getQuality();

    void setQuality(int newQuality);
}
