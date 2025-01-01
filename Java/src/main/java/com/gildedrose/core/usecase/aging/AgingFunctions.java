package com.gildedrose.core.usecase.aging;

import com.gildedrose.core.domain.Range;

import static java.util.Arrays.asList;

public class AgingFunctions {

    public static Range standardQualityRange() { return Range.from(0).toInclusive(50).build();};
    public static Range legendaryQualityRange() { return Range.from(80).toInclusive(80).build();};

    private static AgingFunction simpleAging(int amount){
        StepRange normal = new StepRange(amount, Range.from(0).build());
        StepRange overdue = new StepRange(2 * amount, Range.from(Integer.MIN_VALUE).toExclusive(0).build());

        return new SellInStepsAging(asList(normal, overdue), standardQualityRange());
    }

    public static AgingFunction singleDegrading(){
        return simpleAging(-1);
    }

    public static AgingFunction doubleDegrading(){
        return simpleAging(-2);
    }

    public static AgingFunction improving(){
        return simpleAging(1);
    }

    public static AgingFunction backstagePasses(){
        return new BackstagePassAging(standardQualityRange());
    }

    public static AgingFunction legendary(){
        StepRange normal = new StepRange(0, Range.from(Integer.MIN_VALUE).build());

        return new SellInStepsAging(asList(normal, normal), legendaryQualityRange());
    }
}
