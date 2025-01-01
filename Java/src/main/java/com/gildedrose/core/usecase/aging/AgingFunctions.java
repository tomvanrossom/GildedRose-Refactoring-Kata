package com.gildedrose.core.usecase.aging;

import com.gildedrose.core.domain.Range;

public class AgingFunctions {

    public static Range standardQualityRange() { return Range.from(0).toInclusive(50).build();};
    public static Range legendaryQualityRange() { return Range.from(80).toInclusive(80).build();};

    public static AgingFunction singleDegrading(){
        return new RateAging(-1, standardQualityRange() );
    }

    public static AgingFunction doubleDegrading(){
        return new RateAging(-2, standardQualityRange());
    }

    public static AgingFunction improving(){
        return new RateAging(1, standardQualityRange());
    }

    public static AgingFunction backstagePasses(){
        return new BackstagePassAging(standardQualityRange());
    }

    public static AgingFunction legendary(){
        return new RateAging(0, legendaryQualityRange());
    }
}
