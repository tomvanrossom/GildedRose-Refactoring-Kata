package com.gildedrose.core.usecase.sellin;

class SimpleSellIn implements SellInFunction{
    @Override
    public int nextSellIn(int sellIn) {
        return sellIn-1;
    }
}
