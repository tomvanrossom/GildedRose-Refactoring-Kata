package com.gildedrose.core.usecase.sellin;

class FixedSellIn implements SellInFunction {
    @Override
    public int nextSellIn(int sellIn) {
        return sellIn >= 1 ? sellIn : 1;
    }
}
