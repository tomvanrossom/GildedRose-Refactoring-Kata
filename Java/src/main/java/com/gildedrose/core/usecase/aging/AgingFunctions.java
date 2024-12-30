package com.gildedrose.core.usecase.aging;

public class AgingFunctions {
    public static AgingFunction singleDegrading(){
        return new RateAging(-1, 50);
    }

    public static AgingFunction doubleDegrading(){
        return new RateAging(-2, 50);
    }

    public static AgingFunction improving(){
        return new RateAging(1, 50);
    }

    public static AgingFunction backstagePasses(){
        return new BackstagePassAging();
    }
}
