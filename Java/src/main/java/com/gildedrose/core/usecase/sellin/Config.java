package com.gildedrose.core.usecase.sellin;

public class Config {
    public static SellInFunction simple(){
        return new SimpleSellIn();
    }

    public static FixedSellIn fixed(){
        return new FixedSellIn();
    }
}
