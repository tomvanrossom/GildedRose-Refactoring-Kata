package com.gildedrose.core.usecase.aging;

import com.gildedrose.core.domain.Range;

import static java.util.Arrays.asList;

public class AgingFunctions {

    public static Range standardQualityRange() { return Range.from(0).toInclusive(50).build();};
    public static Range legendaryQualityRange() { return Range.from(80).toInclusive(80).build();};

    static AgingFunction simpleAging(int amount){
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
        StepRange normal = new StepRange(1, Range.from(10).build());
        StepRange tenDaysBefore = new StepRange(2, Range.from(5).toExclusive(10).build());
        StepRange fiveDaysBefore = new StepRange(3, Range.from(0).toExclusive(5).build());

        int dropToZero = Integer.MIN_VALUE;
        StepRange overdue = new StepRange(dropToZero, Range.from(Integer.MIN_VALUE).toExclusive(0).build());

        return new SellInStepsAging(asList(normal, tenDaysBefore, fiveDaysBefore, overdue), standardQualityRange());
    }

    public static AgingFunction legendary(){
        StepRange normal = new StepRange(0, Range.from(Integer.MIN_VALUE).build());

        return new SellInStepsAging(asList(normal, normal), legendaryQualityRange());
    }
}
